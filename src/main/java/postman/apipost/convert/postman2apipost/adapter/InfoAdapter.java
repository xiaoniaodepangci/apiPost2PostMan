package postman.apipost.convert.postman2apipost.adapter;

import org.springframework.stereotype.Component;
import postman.apipost.convert.postman2apipost.apipost.ApiPostJson;
import postman.apipost.convert.postman2apipost.postman.PostManInfo;
import postman.apipost.convert.postman2apipost.postman.PostManJson;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static postman.apipost.convert.postman2apipost.global.Constant.APIPOST_TARGET_TYPE_FOLDER;

/**
 * 接口目录根路径解析适配器
 *
 * @author HC
 *
 */
@Component
public class InfoAdapter extends AbstractBaseAdapter<PostManJson, ApiPostJson> {
    @Override
    public ApiPostJson sourceToTarget(PostManJson source) {

        PostManInfo postManInfo = source.getPostManInfo();
        ApiPostJson apiPostJson = new ApiPostJson();
        apiPostJson.setParentId("0");
        apiPostJson.setProjectId("-1");
        apiPostJson.setTargetId(postManInfo.getPostmanId());
        apiPostJson.setTargetType(APIPOST_TARGET_TYPE_FOLDER);
        apiPostJson.setName(postManInfo.getName());
        apiPostJson.setSort(1);
        apiPostJson.setVersion(1);
        apiPostJson.setStatus(1);
        apiPostJson.setUpdateDay(LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")));
        apiPostJson.setUpdateDtime(System.currentTimeMillis());
        apiPostJson.setCreateDtime(System.currentTimeMillis());
        return apiPostJson;
    }

    @Override
    public PostManJson targetToSource(ApiPostJson target) {
        PostManJson postManJson = new PostManJson();
        PostManInfo postManInfo = new PostManInfo();
        postManInfo.setName(target.getName());
        postManInfo.setPostmanId(target.getTargetId());
        postManJson.setPostManInfo(postManInfo);
        postManInfo.setSchema("https://schema.getpostman.com/json/collection/v2.1.0/collection.json");
        return postManJson;
    }
}
