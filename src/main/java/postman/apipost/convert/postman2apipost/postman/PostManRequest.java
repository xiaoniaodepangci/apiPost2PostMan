package postman.apipost.convert.postman2apipost.postman;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * Auto-generated: 2022-12-29 14:24:37
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
@Data
public class PostManRequest {

    private String method;
    private List<PostManParameter> header;
    @JSONField(name = "body")
    private PostManRequestBody postManRequestBody;
    @JSONField(name = "url")
    private PostManUrl postManUrl;
    private PostManAuth auth;

}