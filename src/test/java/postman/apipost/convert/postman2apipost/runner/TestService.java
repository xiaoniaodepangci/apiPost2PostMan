package postman.apipost.convert.postman2apipost.runner;


import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import postman.apipost.convert.postman2apipost.adapter.FolderAdapter;
import postman.apipost.convert.postman2apipost.adapter.InfoAdapter;
import postman.apipost.convert.postman2apipost.apipost.ApiPostJson;
import postman.apipost.convert.postman2apipost.postman.Item;
import postman.apipost.convert.postman2apipost.postman.PostManJson;
import postman.apipost.convert.postman2apipost.service.PostManToApiPostService;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class TestService {

    FolderAdapter folderAdapter = new FolderAdapter();

    @Autowired
    private PostManToApiPostService postManToApiPostService;

    @Test
    public void test1() {
        List<String> aaa = new ArrayList<>();

        String filePath = "/static/postman.json";
        ClassPathResource readFile = new ClassPathResource(filePath);
        // 获取文件对象
        File file = null;
        PostManJson postManJson = new PostManJson();
        try {
            file = readFile.getFile();

            byte[] bytes = Files.readAllBytes(file.toPath());
            String fileContents = new String(bytes);
            postManJson = JSONObject.parseObject(fileContents, PostManJson.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        String apiPostJson = postManToApiPostService.getApiPostJson(postManJson);

        String apiPostJsonResult =
                System.getProperty("user.dir") + File.separator + "apiPostJsonResult.json";

        BufferedWriter bufferedWriter = null;
        try {
            Path path = Paths.get(apiPostJsonResult);
            if (Files.exists(path)) {
                Files.delete(path);
            }
            bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
            bufferedWriter.write(apiPostJson);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }

    private LinkedList<ApiPostJson> postmanRequestToApiPostRequest(List<Item> item, String parentId) {
        LinkedList<ApiPostJson> apiPostJsons = new LinkedList<>();
        for (Item level1 : item) {
            ApiPostJson apiPostJson = folderAdapter.sourceToTarget(level1);
            apiPostJson.setParentId(parentId);
            apiPostJsons.add(apiPostJson);
            if (level1.getItem() != null && level1.getItem().size() != 0) {
                apiPostJsons.addAll(postmanRequestToApiPostRequest(level1.getItem(), apiPostJson.getTargetId()));
            }
        }
        return apiPostJsons;
    }


    private LinkedList<ApiPostJson> postmanToApiPost(PostManJson postManJson) {
        LinkedList<ApiPostJson> list = new LinkedList<>();
        InfoAdapter infoAdapter = new InfoAdapter();
        list.add(infoAdapter.sourceToTarget(postManJson));
        return list;
    }


    private static final String BEAUTIFY_JS_RESOURCE = "/static/beautify.js";

    // name of beautifier function
    private static final String BEAUTIFY_METHOD_NAME = "js_beautify";

    private ScriptEngine engine;

    @Test
    public void test2() throws ScriptException, NoSuchMethodException, IOException {
        String unformattedJs = "var a = 1, b = 2; var user = { name : \"Andrew\"}";

        engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("var global = this;");
        InputStream inputStream = new ClassPathResource(BEAUTIFY_JS_RESOURCE).getInputStream();
        engine.eval(new InputStreamReader(inputStream));
        String s = (String) ((Invocable) engine).invokeFunction(BEAUTIFY_METHOD_NAME, unformattedJs);
        System.out.println(s);

//        String formattedJs = javascriptBeautifierForJava.beautify(unformattedJs);

//        System.out.println(formattedJs);


    }
}
