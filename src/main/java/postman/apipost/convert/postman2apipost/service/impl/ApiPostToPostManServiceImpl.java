package postman.apipost.convert.postman2apipost.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import postman.apipost.convert.postman2apipost.adapter.APIAdapter;
import postman.apipost.convert.postman2apipost.adapter.FolderAdapter;
import postman.apipost.convert.postman2apipost.adapter.InfoAdapter;
import postman.apipost.convert.postman2apipost.adapter.ScriptAdapter;
import postman.apipost.convert.postman2apipost.apipost.ApiPostJson;
import postman.apipost.convert.postman2apipost.postman.Item;
import postman.apipost.convert.postman2apipost.postman.PostManJson;
import postman.apipost.convert.postman2apipost.service.ApiPostToPostManService;

import java.util.ArrayList;
import java.util.List;

import static postman.apipost.convert.postman2apipost.global.Constant.APIPOST_TARGET_TYPE_API;
import static postman.apipost.convert.postman2apipost.global.Constant.APIPOST_TARGET_TYPE_FOLDER;

@Service
public class ApiPostToPostManServiceImpl implements ApiPostToPostManService {
    @Autowired
    private APIAdapter apiAdapter;
    @Autowired
    private FolderAdapter folderAdapter;
    @Autowired
    private InfoAdapter infoAdapter;
    @Autowired
    private ScriptAdapter scriptAdapter;


    @Override
    public String getPostManJson(List<ApiPostJson> apiPostJsons) {
        return null;
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


}
