package postman.apipost.convert.postman2apipost.service;

import postman.apipost.convert.postman2apipost.apipost.ApiPostJson;
import postman.apipost.convert.postman2apipost.postman.PostManJson;

import java.util.List;

public interface ApiPostToPostManService {


    String getPostManJson(List<ApiPostJson> apiPostJsons);
}
