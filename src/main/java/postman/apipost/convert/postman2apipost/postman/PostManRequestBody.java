package postman.apipost.convert.postman2apipost.postman;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * Auto-generated: 2022-12-29 14:24:37
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
@Data
public class PostManRequestBody {

    private String mode;
    private String raw;
    @JSONField(name = "options")
    private PostManOptions postManOptions;

}