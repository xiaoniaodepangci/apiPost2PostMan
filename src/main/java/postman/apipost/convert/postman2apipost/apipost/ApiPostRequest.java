package postman.apipost.convert.postman2apipost.apipost;
import lombok.Data;

/**
 * Auto-generated: 2022-12-29 14:22:13
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
@Data
public class ApiPostRequest {
    private String url;
    private ApiPostAuth auth;
    private ApiPostRequestBody body;
    private ApiPostRequestEvent event;
    private ApiPostRequestHeader header;
    private ApiPostRequestQuery query;
    private ApiPostRequestCookie cookie;
    private ApiPostRequestResful resful;
    private String description;
}