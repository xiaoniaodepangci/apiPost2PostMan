package postman.apipost.convert.postman2apipost.apipost;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class ApiPostResponse {
    @JSONField(name = "success")
    private ApiPostResponseItem success;
    @JSONField(name = "error")
    private ApiPostResponseItem error;
}
