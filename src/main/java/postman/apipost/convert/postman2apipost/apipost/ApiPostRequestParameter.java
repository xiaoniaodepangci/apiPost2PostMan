package postman.apipost.convert.postman2apipost.apipost;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * Auto-generated: 2022-12-29 14:22:13
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
@Data
public class ApiPostRequestParameter {
    private String description;
    @JSONField(name = "field_type")
    private String fieldType;
    @JSONField(name = "is_checked")
    private Integer isChecked;
    private String key;
    private String value;
    @JSONField(name = "not_null")
    private Integer notNull;
    private String type;
}