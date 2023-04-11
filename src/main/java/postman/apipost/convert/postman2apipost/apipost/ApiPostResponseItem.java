package postman.apipost.convert.postman2apipost.apipost;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ApiPostResponseItem {
    private String raw = "";
    private List<ApiPostRequestParameter> parameter = new ArrayList<>();
}
