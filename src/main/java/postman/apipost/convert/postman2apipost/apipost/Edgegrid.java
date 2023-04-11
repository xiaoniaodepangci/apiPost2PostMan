package postman.apipost.convert.postman2apipost.apipost;
import com.alibaba.fastjson.annotation.JSONField;
/**
 * Auto-generated: 2022-12-29 14:22:13
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Edgegrid {

    @JSONField(name = "accessToken")
    private String accesstoken;
    @JSONField(name = "clientToken")
    private String clienttoken;
    @JSONField(name = "clientSecret")
    private String clientsecret;
    private String nonce;
    private String timestamp;
    @JSONField(name = "baseURi")
    private String baseuri;
    @JSONField(name = "headersToSign")
    private String headerstosign;
    public void setAccesstoken(String accesstoken) {
         this.accesstoken = accesstoken;
     }
     public String getAccesstoken() {
         return accesstoken;
     }

    public void setClienttoken(String clienttoken) {
         this.clienttoken = clienttoken;
     }
     public String getClienttoken() {
         return clienttoken;
     }

    public void setClientsecret(String clientsecret) {
         this.clientsecret = clientsecret;
     }
     public String getClientsecret() {
         return clientsecret;
     }

    public void setNonce(String nonce) {
         this.nonce = nonce;
     }
     public String getNonce() {
         return nonce;
     }

    public void setTimestamp(String timestamp) {
         this.timestamp = timestamp;
     }
     public String getTimestamp() {
         return timestamp;
     }

    public void setBaseuri(String baseuri) {
         this.baseuri = baseuri;
     }
     public String getBaseuri() {
         return baseuri;
     }

    public void setHeaderstosign(String headerstosign) {
         this.headerstosign = headerstosign;
     }
     public String getHeaderstosign() {
         return headerstosign;
     }

}