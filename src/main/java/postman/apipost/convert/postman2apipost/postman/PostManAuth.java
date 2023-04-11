package postman.apipost.convert.postman2apipost.postman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Auto-generated: 2022-12-29 14:22:13
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/ 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostManAuth {
    private String type;
    private List<PostManAuthBearer> bearer;

}