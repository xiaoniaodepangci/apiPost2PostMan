package postman.apipost.convert.postman2apipost.utils;

import lombok.Data;
import postman.apipost.convert.postman2apipost.apipost.ApiPostJson;

import java.util.List;

/**
 * 因为postman转换apipost简单所以不需要dto
 * 但是apipost不像postman的层级结构，apipost有parentid来标识层级 他的整个json实际就是个数组
 *
 * @author HC
 */
@Data
public class ApiToPostManDto {
    private String parentId;
    private String targetId;
    private Integer sort;
    private ApiPostJson apiPostJson;
    private List<ApiToPostManDto> children;
}
