package postman.apipost.convert.postman2apipost.postman;
import lombok.Data;

import java.util.List;

/**
 * Auto-generated: 2022-12-29 14:24:37
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
@Data
public class PostManUrl {

    private String raw;
    private List<String> host;
    private List<String> path;
    private List<PostManParameter> query;
}