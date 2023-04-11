package postman.apipost.convert.postman2apipost.global;

/**
 * @ClassName: ResultJson
 * @Description: todo 添加描述
 * @Author: HC
 * @Date: 2022/12/31 16:57
 * @Version: 1.0
 * @Copy right
 */
@lombok.Data
public class ResultJson {
    private Integer code;
    private String msg;
    private Data data;

}
