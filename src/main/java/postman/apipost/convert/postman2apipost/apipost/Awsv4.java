package postman.apipost.convert.postman2apipost.apipost;
import com.alibaba.fastjson.annotation.JSONField;
/**
 * Auto-generated: 2022-12-29 14:22:13
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Awsv4 {

    @JSONField(name = "accessKey")
    private String accesskey;
    @JSONField(name = "secretKey")
    private String secretkey;
    private String region;
    private String service;
    @JSONField(name = "sessionToken")
    private String sessiontoken;
    @JSONField(name = "addAuthDataToQuery")
    private int addauthdatatoquery;
    public void setAccesskey(String accesskey) {
         this.accesskey = accesskey;
     }
     public String getAccesskey() {
         return accesskey;
     }

    public void setSecretkey(String secretkey) {
         this.secretkey = secretkey;
     }
     public String getSecretkey() {
         return secretkey;
     }

    public void setRegion(String region) {
         this.region = region;
     }
     public String getRegion() {
         return region;
     }

    public void setService(String service) {
         this.service = service;
     }
     public String getService() {
         return service;
     }

    public void setSessiontoken(String sessiontoken) {
         this.sessiontoken = sessiontoken;
     }
     public String getSessiontoken() {
         return sessiontoken;
     }

    public void setAddauthdatatoquery(int addauthdatatoquery) {
         this.addauthdatatoquery = addauthdatatoquery;
     }
     public int getAddauthdatatoquery() {
         return addauthdatatoquery;
     }

}