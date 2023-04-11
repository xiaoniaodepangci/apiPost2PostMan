package postman.apipost.convert.postman2apipost.listcreate;

import com.alibaba.fastjson.JSONObject;
import org.springframework.core.io.ClassPathResource;
import postman.apipost.convert.postman2apipost.apipost.ApiPostJson;
import postman.apipost.convert.postman2apipost.postman.Item;
import postman.apipost.convert.postman2apipost.postman.PostManAuth;
import postman.apipost.convert.postman2apipost.postman.PostManAuthBearer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PostManCreateUtils {

    public static <T> T getItemByFile(String filePath, Class<T> clazz) {
        ClassPathResource readFile = new ClassPathResource(filePath);
        // 获取文件对象
        File file = null;
        try {
            file = readFile.getFile();
            byte[] bytes = Files.readAllBytes(file.toPath());
            String fileContents = new String(bytes);
            return JSONObject.parseObject(fileContents, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Item getCheckInSingleList() {
        Item root = new Item();

        List<Item> list = new ArrayList<>();


        root.setName("旅客值机单查分类");
        root.setAuth(new PostManAuth());
        return root;
    }

    public static PostManAuth getNoAuthPostManAuth() {
        PostManAuth postManAuth = new PostManAuth();
        postManAuth.setType("noauth");
        postManAuth.setBearer(null);
        return postManAuth;
    }

    public static PostManAuth getBearerPostManAuth() {
        PostManAuth postManAuth = new PostManAuth();
        postManAuth.setType("bearer");
        PostManAuthBearer postManAuthBearer = new PostManAuthBearer();
        postManAuthBearer.setKey("token");
        postManAuthBearer.setValue("{{token}}");
        postManAuthBearer.setType("string");
        postManAuth.setBearer(Collections.singletonList(postManAuthBearer));
        return postManAuth;
    }
}
