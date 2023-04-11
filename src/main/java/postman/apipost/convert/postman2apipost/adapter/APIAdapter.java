package postman.apipost.convert.postman2apipost.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import postman.apipost.convert.postman2apipost.apipost.*;
import postman.apipost.convert.postman2apipost.postman.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

import static postman.apipost.convert.postman2apipost.global.Constant.APIPOST_PROJECT_ID;
import static postman.apipost.convert.postman2apipost.global.Constant.APIPOST_TARGET_TYPE_API;

/**
 * 目录转换适配器
 *
 * @author HC
 */
@Component
public class APIAdapter extends AbstractBaseAdapter<Item, ApiPostJson> {
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
        apiPostJson.setTargetType(APIPOST_TARGET_TYPE_API);
        apiPostJson.setName(source.getName());
        PostManRequest postManRequest = source.getPostManRequest();
        apiPostJson.setMethod(postManRequest.getMethod());
        apiPostJson.setUrl(postManRequest.getPostManUrl().getRaw());
        // request部分
        ApiPostRequest apiPostRequest = new ApiPostRequest();
        apiPostRequest.setUrl(postManRequest.getPostManUrl().getRaw());
//            AUTH
        ApiPostAuth apiPostAuth = new ApiPostAuth();
        PostManAuth postManAuth = postManRequest.getAuth();
        if (postManAuth != null) {
            if ("noauth".equals(postManAuth.getType())) {
                apiPostAuth.setType("noauth");
            } else {
                apiPostAuth.setType(postManRequest.getAuth().getType());
            }
            if ("bearer".equals(postManRequest.getAuth().getType())) {
                ApiPostAuthBearer apiPostAuthBearer = new ApiPostAuthBearer();
                apiPostAuthBearer.setKey(postManRequest.getAuth().getBearer().get(0).getValue());
                apiPostAuth.setBearer(apiPostAuthBearer);
            }
        }
        apiPostRequest.setAuth(apiPostAuth);
//            BODY
        ApiPostRequestBody apiPostRequestBody = new ApiPostRequestBody();
        PostManRequestBody postManRequestBody = postManRequest.getPostManRequestBody();
        if (postManRequestBody != null) {
            if ("raw".equals(postManRequestBody.getMode())) {
                apiPostRequestBody.setMode(postManRequestBody.getPostManOptions().getPostManRaw().getLanguage());
                apiPostRequestBody.setRaw(postManRequestBody.getRaw());
            }

        }
        apiPostRequest.setBody(apiPostRequestBody);
//          预执行脚本与执行后脚本
        ApiPostRequestEvent apiPostRequestEvent = new ApiPostRequestEvent();
        List<PostManEvent> postManEvent = source.getPostManEvent();
        if (postManEvent != null && postManEvent.size() != 0) {
            apiPostRequestEvent = scriptAdapter.sourceToTarget(postManEvent);
        }
        apiPostRequest.setEvent(apiPostRequestEvent);

//            header与query
        ApiPostRequestHeader apiPostRequestHeader = new ApiPostRequestHeader();
        ApiPostRequestQuery apiPostRequestQuery = new ApiPostRequestQuery();
        ApiPostRequestCookie apiPostRequestCookie = new ApiPostRequestCookie();
        ApiPostRequestResful apiPostRequestResful = new ApiPostRequestResful();

        List<ApiPostRequestParameter> apiPostHeaders = new ArrayList<>();
        List<ApiPostRequestParameter> apiPostQuery = new ArrayList<>();
        List<ApiPostRequestParameter> apiPostCookie = new ArrayList<>();
        List<ApiPostRequestParameter> apiPostResful = new ArrayList<>();

        List<PostManParameter> header = postManRequest.getHeader();
        if (header != null) {
            for (PostManParameter postManParameter : header) {
                ApiPostRequestParameter apiPostRequestParameter = new ApiPostRequestParameter();
                apiPostRequestParameter.setFieldType("String");
                apiPostRequestParameter.setIsChecked(1);
                apiPostRequestParameter.setKey(postManParameter.getKey());
                apiPostRequestParameter.setValue(postManParameter.getValue());
                apiPostRequestParameter.setNotNull(1);
                apiPostRequestParameter.setType("Text");
                apiPostHeaders.add(apiPostRequestParameter);
            }
            apiPostRequestHeader.setParameter(apiPostHeaders);
            apiPostRequest.setHeader(apiPostRequestHeader);
        }

        List<PostManParameter> query = postManRequest.getPostManUrl().getQuery();
        if (query != null) {
            for (PostManParameter postManParameter : query) {
                ApiPostRequestParameter apiPostRequestParameter = new ApiPostRequestParameter();
                apiPostRequestParameter.setFieldType("String");
                apiPostRequestParameter.setIsChecked(1);
                apiPostRequestParameter.setKey(postManParameter.getKey());
                apiPostRequestParameter.setValue(postManParameter.getValue());
                apiPostRequestParameter.setNotNull(1);
                apiPostRequestParameter.setType("Text");
                apiPostQuery.add(apiPostRequestParameter);
            }
            apiPostRequestQuery.setParameter(apiPostQuery);
            apiPostRequest.setQuery(apiPostRequestQuery);
        } else {
            apiPostRequestQuery.setParameter(apiPostQuery);
            apiPostRequest.setQuery(apiPostRequestQuery);
        }


//        ApiPostRequestParameter apiPostRequestCookieParameter = new ApiPostRequestParameter();
//        apiPostCookie.add(null);
        apiPostRequestCookie.setParameter(apiPostCookie);
        apiPostRequest.setCookie(apiPostRequestCookie);

//        ApiPostRequestParameter apiPostRequestResfulParameter = new ApiPostRequestParameter();
//        apiPostResful.add(null);
        apiPostRequestResful.setParameter(apiPostResful);
        apiPostRequest.setResful(apiPostRequestResful);

        apiPostJson.setApiPostRequest(apiPostRequest);

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
        item.setResponse(new ArrayList<String>());

//        执行脚本转换

        if (source.getApiPostRequest().getEvent() != null) {
            item.setPostManEvent(scriptAdapter.targetToSource(source.getApiPostRequest().getEvent()));
        } else {
            item.setPostManEvent(null);
        }
        // request转换
//        request auth节点
        ApiPostRequest apiPostRequest = source.getApiPostRequest();
        PostManRequest postManRequest = new PostManRequest();
        ApiPostAuth apiPostAuth = apiPostRequest.getAuth();
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
        postManRequest.setAuth(postManAuth);

//        method节点
        postManRequest.setMethod(source.getMethod());
//        header节点
        ApiPostRequestHeader header = apiPostRequest.getHeader();
        List<ApiPostRequestParameter> parameter = header.getParameter();
        List<PostManParameter> postManParameters = new ArrayList<>();
        for (ApiPostRequestParameter apiPostRequestParameter : parameter) {
            PostManParameter postManParameter = new PostManParameter();
            postManParameter.setKey(apiPostRequestParameter.getKey());
            postManParameter.setValue(apiPostRequestParameter.getValue());
            postManParameter.setType("default");
            postManParameters.add(postManParameter);
        }
        postManRequest.setHeader(postManParameters);

//      body
        PostManRequestBody postManRequestBody = new PostManRequestBody();
        postManRequestBody.setMode("raw");
        postManRequestBody.setRaw(apiPostRequest.getBody().getRaw());
        PostManRaw postManRaw = new PostManRaw();
        PostManOptions postManOptions = new PostManOptions();
        postManRaw.setLanguage("json");
        postManOptions.setPostManRaw(postManRaw);
        postManRequestBody.setPostManOptions(postManOptions);
        postManRequest.setPostManRequestBody(postManRequestBody);


        // url节点
        PostManUrl postManUrl = new PostManUrl();
        postManUrl.setRaw(apiPostRequest.getUrl());
        String[] split = apiPostRequest.getUrl().split("/");
        postManUrl.setHost(Collections.singletonList(split[0]));
        postManUrl.setPath(Arrays.asList(split).subList(1, split.length));
        // url节点 header
        List<PostManParameter> postManQuery = new ArrayList<>();
        ApiPostRequestQuery query = apiPostRequest.getQuery();
        if (query != null) {
            List<ApiPostRequestParameter> apiPostQuerys = query.getParameter();
            for (ApiPostRequestParameter apiPostRequestParameter : apiPostQuerys) {
                PostManParameter postManParameter = new PostManParameter();
                postManParameter.setKey(apiPostRequestParameter.getKey());
                postManParameter.setValue(apiPostRequestParameter.getValue());
                postManQuery.add(postManParameter);
            }
            postManUrl.setQuery(postManQuery);
        } else {
            postManUrl.setQuery(null);
        }
        postManRequest.setPostManUrl(postManUrl);
        item.setPostManRequest(postManRequest);
        item.setItem(null);
        item.setResponse(null);
        return item;
    }
}
