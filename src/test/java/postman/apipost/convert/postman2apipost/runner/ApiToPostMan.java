package postman.apipost.convert.postman2apipost.runner;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import postman.apipost.convert.postman2apipost.adapter.*;
import postman.apipost.convert.postman2apipost.apipost.ApiPostJson;
import postman.apipost.convert.postman2apipost.postman.Item;
import postman.apipost.convert.postman2apipost.postman.PostManJson;
import postman.apipost.convert.postman2apipost.utils.ApiToPostManDto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static postman.apipost.convert.postman2apipost.global.Constant.APIPOST_TARGET_TYPE_API;
import static postman.apipost.convert.postman2apipost.global.Constant.APIPOST_TARGET_TYPE_FOLDER;

@SpringBootTest
public class ApiToPostMan {
    @Autowired
    private APIAdapter apiAdapter;
    @Autowired
    private FolderAdapter folderAdapter;
    @Autowired
    private InfoAdapter infoAdapter;
    @Autowired
    private ScriptAdapter scriptAdapter;

    @Test
    public void test2() {
        String filePath = "/static/apipost-0404.json";
        ClassPathResource readFile = new ClassPathResource(filePath);
        // 获取文件对象
        File file = null;
        List<ApiPostJson> apiPostJsons = new LinkedList<>();
        try {
            file = readFile.getFile();

            byte[] bytes = Files.readAllBytes(file.toPath());
            String fileContents = new String(bytes);
            apiPostJsons = JSONObject.parseArray(fileContents, ApiPostJson.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        PostManJson postManJson = new PostManJson();
        ApiPostJson apiPostJsonRoot = apiPostJsons.get(0);
        postManJson = infoAdapter.targetToSource(apiPostJsonRoot);


        List<ApiPostJson> apiInfo = apiPostJsons.subList(1, apiPostJsons.size());

        List<Item> itemList = getItemList(apiInfo);

        postManJson.setItem(buildTree(apiPostJsonRoot.getTargetId(), itemList));


        String apiPostJsonResult =
                System.getProperty("user.dir") + File.separator + "postManResult1.json";

        BufferedWriter bufferedWriter = null;

        PropertyFilter propertyFilter = (source, key, value) -> {
            if (value == null) {
                return false;
            }
            if (value instanceof String && StringUtils.isBlank(String.valueOf(value))) {
                return false;
            }
            if (value instanceof List && ((List<?>) value).size() == 0) {
                return false;
            }
            return true;
        };
        try {
            Path path = Paths.get(apiPostJsonResult);
            if (Files.exists(path)) {
                Files.delete(path);
            }
            bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
            bufferedWriter.write(JSONObject.toJSONString(postManJson, propertyFilter));
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }


    private List<Item> getItemList(List<ApiPostJson> apiPostJsons) {
        List<Item> list = new ArrayList<>();

        for (ApiPostJson apiPostJson : apiPostJsons) {
            Item item = new Item();
            if (APIPOST_TARGET_TYPE_FOLDER.equals(apiPostJson.getTargetType())) {
                // 文件夹类型
                item = folderAdapter.targetToSource(apiPostJson);
            } else if (APIPOST_TARGET_TYPE_API.equals(apiPostJson.getTargetType())) {
                item = apiAdapter.targetToSource(apiPostJson);
            }
            item.setTargetId(apiPostJson.getTargetId());
            item.setParentId(apiPostJson.getParentId());
            item.setSort(apiPostJson.getSort());
            list.add(item);
        }
        return list;
    }

    public static List<Item> buildTree(String rootId, List<Item> list) {
        return list.stream()
                .filter(menu -> rootId.equals(menu.getParentId()))
                .peek(menu -> menu.setItem(getChildrens(menu, list)))
                .sorted(Comparator.comparing(Item::getSort))
                .collect(Collectors.toList());
    }

    public static List<Item> getChildrens(Item root, List<Item> allMenus) {
        return allMenus.stream()
                .filter(menu -> Objects.equals(menu.getParentId(), root.getTargetId()))
                .peek(menu -> menu.setItem(getChildrens(menu, allMenus)))
                .sorted(Comparator.comparing(Item::getSort))
                .collect(Collectors.toList());
    }

}
