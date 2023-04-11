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
public class ApiPostJson {

    @JSONField(name = "target_id")
    private String targetId;

    @JSONField(name = "parent_id")
    private String parentId;

    @JSONField(name = "project_id")
    private String projectId;

    @JSONField(name = "mark")
    private String mark = "developing";

    @JSONField(name = "target_type")
    private String targetType;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "method")
    private String method;

    @JSONField(name = "sort")
    private int sort;

    @JSONField(name = "type_sort")
    private int typeSort = 1;

    @JSONField(name = "update_day")
    private long updateDay;

    @JSONField(name = "update_dtime")
    private long updateDtime;

    @JSONField(name = "bak_id")
    private long bakId = 0;

    @JSONField(name = "version")
    private int version = 1;

    @JSONField(name = "is_publish")
    private int isPublish = 0;

    @JSONField(name = "publisher")
    private int publisher = 0;

    @JSONField(name = "publish_dtime")
    private long publishDtime = 1L;

    @JSONField(name = "create_dtime")
    private long createDtime;

    @JSONField(name = "is_doc")
    private int isDoc = 1;

    @JSONField(name = "request")
    private ApiPostRequest apiPostRequest;

    @JSONField(name = "response")
    private ApiPostResponse apiPostResponse;

    @JSONField(name = "is_changed")
    private int isChanged = -1;

    private String url;

    private int status;

    @JSONField(name = "modifier_id")
    private String modifierId;

    @JSONField(name = "script")
    private ApiPostScript apiPostScript;

    @JSONField(name = "mock_url")
    private String mockUrl = "";

    @JSONField(name = "mock")
    private String mock = "";
}