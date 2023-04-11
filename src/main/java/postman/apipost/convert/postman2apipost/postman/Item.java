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
public class Item {
    @JSONField(serialize = false)
    private String parentId;
    @JSONField(serialize = false)
    private String targetId;
    @JSONField(serialize = false)
    private Integer sort;

    private String name;
    @JSONField(name = "event")
    private List<PostManEvent> postManEvent;
    @JSONField(name = "request")
    private PostManRequest postManRequest;
    private List<String> response;
    private PostManAuth auth;
    @JSONField(name = "item")
    private List<Item> item;
}