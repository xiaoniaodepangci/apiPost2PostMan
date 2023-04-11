package postman.apipost.convert.postman2apipost.adapter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import postman.apipost.convert.postman2apipost.apipost.*;
import postman.apipost.convert.postman2apipost.postman.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static postman.apipost.convert.postman2apipost.global.Constant.*;

/**
 * 目录转换适配器
 *
 * @author HC
 */
@Component
public class FolderAdapter extends AbstractBaseAdapter<Item, ApiPostJson> {
    @Autowired
    private ScriptAdapter scriptAdapter;

    @Override
    public ApiPostJson sourceToTarget(Item source) {
        ApiPostJson apiPostJson = new ApiPostJson();
        apiPostJson.setVersion(1);
        apiPostJson.setStatus(1);
        apiPostJson.setUpdateDay(LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")));
        apiPostJson.setUpdateDtime(System.currentTimeMillis());
        apiPostJson.setCreateDtime(System.currentTimeMillis());
        apiPostJson.setProjectId(APIPOST_PROJECT_ID);
        apiPostJson.setTargetId(String.valueOf(UUID.randomUUID()));
        apiPostJson.setTargetType(APIPOST_TARGET_TYPE_FOLDER);
        apiPostJson.setName(source.getName());
        apiPostJson.setMethod(APIPOST_DEFAULT_METHOD);

//        兼容apipost6 文件夹也需要request和script
        PostManAuth postManAuth = source.getAuth();
        ApiPostRequest apiPostRequest = new ApiPostRequest();
        ApiPostRequestHeader apiPostRequestHeader = new ApiPostRequestHeader();
        ApiPostRequestQuery apiPostRequestQuery = new ApiPostRequestQuery();
        ApiPostRequestBody apiPostRequestBody = new ApiPostRequestBody();
        ApiPostAuth apiPostAuth = new ApiPostAuth();
        if (postManAuth != null) {
            if ("noauth".equals(postManAuth.getType())) {
                apiPostAuth.setType("noauth");
            } else {
                apiPostAuth.setType(postManAuth.getType());
            }
            if ("bearer".equals(postManAuth.getType())) {
                ApiPostAuthBearer apiPostAuthBearer = new ApiPostAuthBearer();
                apiPostAuthBearer.setKey(postManAuth.getBearer().get(0).getValue());
                apiPostAuth.setBearer(apiPostAuthBearer);
            }
        }

        apiPostRequest.setAuth(apiPostAuth);
        apiPostRequest.setHeader(apiPostRequestHeader);
        apiPostRequest.setQuery(apiPostRequestQuery);
        apiPostRequest.setBody(apiPostRequestBody);
        apiPostRequest.setDescription("");
        apiPostJson.setApiPostRequest(apiPostRequest);

//        目录级预执行脚本与执行后脚本
        List<PostManEvent> postManEvent = source.getPostManEvent();
        ApiPostScript apiPostScript = new ApiPostScript();
        if (postManEvent != null && postManEvent.size() != 0) {
            BeanUtils.copyProperties(scriptAdapter.sourceToTarget(postManEvent), apiPostScript);
            apiPostScript.setPreScriptSwitch(true);
            apiPostScript.setTestSwitch(true);
        }
        apiPostJson.setApiPostScript(apiPostScript);

        ApiPostResponse apiPostResponse = new ApiPostResponse();
        apiPostResponse.setError(new ApiPostResponseItem());
        apiPostResponse.setSuccess(new ApiPostResponseItem());
        apiPostJson.setApiPostResponse(apiPostResponse);
        return apiPostJson;
    }

    @Override
    public Item targetToSource(ApiPostJson source) {
        Item item = new Item();
        item.setName(source.getName());

        // 预执行脚本
        if (source.getApiPostScript()!=null){
            item.setPostManEvent(scriptAdapter.targetToSource(source.getApiPostScript()));
        }else {
            item.setPostManEvent(null);
        }
        // 授权 auth
        if (source.getApiPostRequest() != null){
            if (source.getApiPostRequest().getAuth() !=null){
                ApiPostAuth apiPostAuth = source.getApiPostRequest().getAuth();
                PostManAuth postManAuth = new PostManAuth();
                List<PostManAuthBearer> bearers = new ArrayList<>();

                if ("noauth".equals(apiPostAuth.getType())) {
                    postManAuth.setType("noauth");
                } else {
                    postManAuth.setType(postManAuth.getType());
                }

                if ("bearer".equals(apiPostAuth.getType())) {
                    PostManAuthBearer postManAuthBearer = new PostManAuthBearer();
                    postManAuthBearer.setKey("token");
                    postManAuthBearer.setValue(apiPostAuth.getBearer().getKey());
                    postManAuthBearer.setType("string");
                    bearers.add(postManAuthBearer);
                }
                postManAuth.setBearer(bearers);
                item.setAuth(postManAuth);
            }else {
                item.setAuth(null);

            }
        }else {
            item.setPostManRequest(null);
        }

        return item;
    }
}
