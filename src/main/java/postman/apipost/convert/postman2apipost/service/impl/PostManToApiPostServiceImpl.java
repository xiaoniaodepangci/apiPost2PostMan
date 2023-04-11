package postman.apipost.convert.postman2apipost.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import postman.apipost.convert.postman2apipost.adapter.APIAdapter;
import postman.apipost.convert.postman2apipost.adapter.FolderAdapter;
import postman.apipost.convert.postman2apipost.adapter.InfoAdapter;
import postman.apipost.convert.postman2apipost.apipost.*;
import postman.apipost.convert.postman2apipost.postman.Item;
import postman.apipost.convert.postman2apipost.postman.PostManJson;
import postman.apipost.convert.postman2apipost.service.PostManToApiPostService;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: PostManToApiPostServiceImpl
 * @Description: todo 添加描述
 * @Author: HC
 * @Date: 2022/12/31 17:03
 * @Version: 1.0
 * @Copy right
 */
@Service
public class PostManToApiPostServiceImpl implements PostManToApiPostService {
    @Autowired
    private FolderAdapter folderAdapter;
    @Autowired
    private APIAdapter apiAdapter;

    @Autowired
    private InfoAdapter infoAdapter;

    @Override
    public String getApiPostJson(PostManJson postManJson) {
//        转换postman的info字段 生成apipost第一个结点
        LinkedList<ApiPostJson> apiPostJsons = postmanToApiPost(postManJson);

        List<Item> item = postManJson.getItem();
        LinkedList<ApiPostJson> apiPostJsons1 = postmanRequestToApiPostRequest(item, apiPostJsons.get(0).getTargetId());
        apiPostJsons.addAll(apiPostJsons1);
        return JSONObject.toJSONString(apiPostJsons);
    }

    private LinkedList<ApiPostJson> postmanRequestToApiPostRequest(List<Item> item, String parentId) {
        LinkedList<ApiPostJson> apiPostJsons = new LinkedList<>();
        for (Item level1 : item) {
            ApiPostJson apiPostJson = new ApiPostJson();
            if (level1.getItem() != null) {
                apiPostJson = folderAdapter.sourceToTarget(level1);
            } else {
                apiPostJson = apiAdapter.sourceToTarget(level1);
            }
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
        ApiPostJson apiPostJson = infoAdapter.sourceToTarget(postManJson);

        ApiPostRequest apiPostRequest = new ApiPostRequest();
        ApiPostRequestHeader apiPostRequestHeader = new ApiPostRequestHeader();
        ApiPostRequestQuery apiPostRequestQuery = new ApiPostRequestQuery();
        ApiPostRequestBody apiPostRequestBody = new ApiPostRequestBody();
        ApiPostAuth apiPostAuth = new ApiPostAuth();
        apiPostAuth.setType("noauth");
        apiPostRequest.setAuth(apiPostAuth);
        apiPostRequest.setHeader(apiPostRequestHeader);
        apiPostRequest.setQuery(apiPostRequestQuery);
        apiPostRequest.setBody(apiPostRequestBody);
        apiPostRequest.setDescription("");
        apiPostJson.setApiPostRequest(apiPostRequest);

        ApiPostScript apiPostScript = new ApiPostScript();
        apiPostScript.setPreScript("");
        apiPostScript.setTest("");
        apiPostJson.setApiPostScript(apiPostScript);


        list.add(apiPostJson);
        return list;
    }
}
