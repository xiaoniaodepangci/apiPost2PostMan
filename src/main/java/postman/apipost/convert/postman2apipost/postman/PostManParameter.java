package postman.apipost.convert.postman2apipost.postman;

import lombok.Data;

/**
 * @ClassName: PostManParameter
 * @Description: todo 添加描述
 * @Author: HC
 * @Date: 2022/12/31 15:01
 * @Version: 1.0
 * @Copy right
 */
@Data
public class PostManParameter {
    private String key;
    private String value;
    private String type;
}
