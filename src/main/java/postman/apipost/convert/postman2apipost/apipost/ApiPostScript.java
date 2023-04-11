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
public class ApiPostScript extends ApiPostRequestEvent {
    @JSONField(name = "pre_script_switch")
    private boolean preScriptSwitch = true;
    @JSONField(name = "test_switch")
    private boolean testSwitch = true;
}