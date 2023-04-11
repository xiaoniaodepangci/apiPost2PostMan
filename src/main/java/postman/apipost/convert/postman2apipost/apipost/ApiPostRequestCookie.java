package postman.apipost.convert.postman2apipost.apipost;

import lombok.Data;

import java.util.List;

/**
 * @ClassName: ApiPostRequestBodyHeader
 * @Description: todo 添加描述
 * @Author: HC
 * @Date: 2022/12/31 14:42
 * @Version: 1.0
 * @Copy right
 */

@Data
public class ApiPostRequestCookie {

    private List<ApiPostRequestParameter> parameter;
}
