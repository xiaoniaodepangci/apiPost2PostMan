package postman.apipost.convert.postman2apipost.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import postman.apipost.convert.postman2apipost.apipost.ApiPostJson;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("/1")
    public void test() {
        String apiTest = "{\n" +
                "\t\"parent_id\": \"0\",\n" +
                "\t\"project_id\": \"-1\",\n" +
                "\t\"target_id\": \"1bdd7f2a-957a-4e3f-b4f1-eecb6bb7c861\",\n" +
                "\t\"target_type\": \"api\",\n" +
                "\t\"name\": \"值机登录\",\n" +
                "\t\"sort\": 1,\n" +
                "\t\"version\": 1,\n" +
                "\t\"mark\": \"developing\",\n" +
                "\t\"update_day\": 1672156800000,\n" +
                "\t\"update_dtime\": 1672215389,\n" +
                "\t\"create_dtime\": 1672214975,\n" +
                "\t\"status\": 1,\n" +
                "\t\"modifier_id\": \"-1\",\n" +
                "\t\"method\": \"POST\",\n" +
                "\t\"mock\": \"{}\",\n" +
                "\t\"mock_url\": \"\",\n" +
                "\t\"url\": \"{{nginx}}/{{context-path}}/1.0/external/login\",\n" +
                "\t\"request\": {\n" +
                "\t\t\"url\": \"{{nginx}}/{{context-path}}/1.0/external/login\",\n" +
                "\t\t\"description\": \"\",\n" +
                "\t\t\"auth\": {\n" +
                "\t\t\t\"type\": \"noauth\",\n" +
                "\t\t\t\"kv\": {\n" +
                "\t\t\t\t\"key\": \"\",\n" +
                "\t\t\t\t\"value\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"bearer\": {\n" +
                "\t\t\t\t\"key\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"basic\": {\n" +
                "\t\t\t\t\"username\": \"\",\n" +
                "\t\t\t\t\"password\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"digest\": {\n" +
                "\t\t\t\t\"username\": \"\",\n" +
                "\t\t\t\t\"password\": \"\",\n" +
                "\t\t\t\t\"realm\": \"\",\n" +
                "\t\t\t\t\"nonce\": \"\",\n" +
                "\t\t\t\t\"algorithm\": \"\",\n" +
                "\t\t\t\t\"qop\": \"\",\n" +
                "\t\t\t\t\"nc\": \"\",\n" +
                "\t\t\t\t\"cnonce\": \"\",\n" +
                "\t\t\t\t\"opaque\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"hawk\": {\n" +
                "\t\t\t\t\"authId\": \"\",\n" +
                "\t\t\t\t\"authKey\": \"\",\n" +
                "\t\t\t\t\"algorithm\": \"\",\n" +
                "\t\t\t\t\"user\": \"\",\n" +
                "\t\t\t\t\"nonce\": \"\",\n" +
                "\t\t\t\t\"extraData\": \"\",\n" +
                "\t\t\t\t\"app\": \"\",\n" +
                "\t\t\t\t\"delegation\": \"\",\n" +
                "\t\t\t\t\"timestamp\": \"\",\n" +
                "\t\t\t\t\"includePayloadHash\": -1\n" +
                "\t\t\t},\n" +
                "\t\t\t\"awsv4\": {\n" +
                "\t\t\t\t\"accessKey\": \"\",\n" +
                "\t\t\t\t\"secretKey\": \"\",\n" +
                "\t\t\t\t\"region\": \"\",\n" +
                "\t\t\t\t\"service\": \"\",\n" +
                "\t\t\t\t\"sessionToken\": \"\",\n" +
                "\t\t\t\t\"addAuthDataToQuery\": -1\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ntlm\": {\n" +
                "\t\t\t\t\"username\": \"\",\n" +
                "\t\t\t\t\"password\": \"\",\n" +
                "\t\t\t\t\"domain\": \"\",\n" +
                "\t\t\t\t\"workstation\": \"\",\n" +
                "\t\t\t\t\"disableRetryRequest\": 1\n" +
                "\t\t\t},\n" +
                "\t\t\t\"edgegrid\": {\n" +
                "\t\t\t\t\"accessToken\": \"\",\n" +
                "\t\t\t\t\"clientToken\": \"\",\n" +
                "\t\t\t\t\"clientSecret\": \"\",\n" +
                "\t\t\t\t\"nonce\": \"\",\n" +
                "\t\t\t\t\"timestamp\": \"\",\n" +
                "\t\t\t\t\"baseURi\": \"\",\n" +
                "\t\t\t\t\"headersToSign\": \"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"oauth1\": {\n" +
                "\t\t\t\t\"consumerKey\": \"\",\n" +
                "\t\t\t\t\"consumerSecret\": \"\",\n" +
                "\t\t\t\t\"signatureMethod\": \"\",\n" +
                "\t\t\t\t\"addEmptyParamsToSign\": -1,\n" +
                "\t\t\t\t\"includeBodyHash\": -1,\n" +
                "\t\t\t\t\"addParamsToHeader\": -1,\n" +
                "\t\t\t\t\"realm\": \"\",\n" +
                "\t\t\t\t\"version\": \"1.0\",\n" +
                "\t\t\t\t\"nonce\": \"\",\n" +
                "\t\t\t\t\"timestamp\": \"\",\n" +
                "\t\t\t\t\"verifier\": \"\",\n" +
                "\t\t\t\t\"callback\": \"\",\n" +
                "\t\t\t\t\"tokenSecret\": \"\",\n" +
                "\t\t\t\t\"token\": \"\"\n" +
                "\t\t\t}\n" +
                "\t\t},\n" +
                "\t\t\"body\": {\n" +
                "\t\t\t\"mode\": \"json\",\n" +
                "\t\t\t\"parameter\": [],\n" +
                "\t\t\t\"raw\": \"{\\r\\n\\t\\\"username\\\": \\\"{{checkin-user}}\\\",\\r\\n\\t\\\"password\\\": \\\"{{checkin-pass}}\\\"\\r\\n}\",\n" +
                "\t\t\t\"raw_para\": []\n" +
                "\t\t},\n" +
                "\t\t\"event\": {\n" +
                "\t\t\t\"pre_script\": \"console.log(\\\"aaaa\\\")\",\n" +
                "\t\t\t\"test\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"header\": {\n" +
                "\t\t\t\"parameter\": []\n" +
                "\t\t},\n" +
                "\t\t\"query\": {\n" +
                "\t\t\t\"parameter\": []\n" +
                "\t\t},\n" +
                "\t\t\"cookie\": {\n" +
                "\t\t\t\"parameter\": []\n" +
                "\t\t},\n" +
                "\t\t\"resful\": {\n" +
                "\t\t\t\"parameter\": []\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t\"response\": {\n" +
                "\t\t\"success\": {\n" +
                "\t\t\t\"raw\": \"\",\n" +
                "\t\t\t\"parameter\": [],\n" +
                "\t\t\t\"expect\": {\n" +
                "\t\t\t\t\"name\": \"成功\",\n" +
                "\t\t\t\t\"isDefault\": 1,\n" +
                "\t\t\t\t\"code\": 200,\n" +
                "\t\t\t\t\"contentType\": \"json\",\n" +
                "\t\t\t\t\"verifyType\": \"schema\",\n" +
                "\t\t\t\t\"mock\": \"\",\n" +
                "\t\t\t\t\"schema\": {}\n" +
                "\t\t\t}\n" +
                "\t\t},\n" +
                "\t\t\"error\": {\n" +
                "\t\t\t\"raw\": \"\",\n" +
                "\t\t\t\"parameter\": [],\n" +
                "\t\t\t\"expect\": {\n" +
                "\t\t\t\t\"name\": \"失败\",\n" +
                "\t\t\t\t\"isDefault\": -1,\n" +
                "\t\t\t\t\"code\": 404,\n" +
                "\t\t\t\t\"contentType\": \"json\",\n" +
                "\t\t\t\t\"verifyType\": \"schema\",\n" +
                "\t\t\t\t\"mock\": \"\",\n" +
                "\t\t\t\t\"schema\": {}\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t\"is_check_result\": 1,\n" +
                "\t\"check_result_expectId\": \"\",\n" +
                "\t\"is_example\": 0,\n" +
                "\t\"is_locked\": -1,\n" +
                "\t\"enable_ai_expect\": -1,\n" +
                "\t\"enable_server_mock\": -1,\n" +
                "\t\"ai_expect\": {\n" +
                "\t\t\"none_math_expect_id\": \"\",\n" +
                "\t\t\"list\": []\n" +
                "\t},\n" +
                "\t\"is_changed\": -1,\n" +
                "\t\"type_sort\": \"1\",\n" +
                "\t\"is_first_match\": 1\n" +
                "}";
        ApiPostJson apiPostJson = JSONObject.parseObject(apiTest, ApiPostJson.class);

        System.out.println(JSONObject.toJSONString(apiPostJson));


    }
}
