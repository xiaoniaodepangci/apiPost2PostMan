package postman.apipost.convert.postman2apipost.apipost;
import com.alibaba.fastjson.annotation.JSONField;
/**
 * Auto-generated: 2022-12-29 14:22:13
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Oauth1 {

    @JSONField(name = "consumerKey")
    private String consumerkey;
    @JSONField(name = "consumerSecret")
    private String consumersecret;
    @JSONField(name = "signatureMethod")
    private String signaturemethod;
    @JSONField(name = "addEmptyParamsToSign")
    private int addemptyparamstosign;
    @JSONField(name = "includeBodyHash")
    private int includebodyhash;
    @JSONField(name = "addParamsToHeader")
    private int addparamstoheader;
    private String realm;
    private String version;
    private String nonce;
    private String timestamp;
    private String verifier;
    private String callback;
    @JSONField(name = "tokenSecret")
    private String tokensecret;
    private String token;
    public void setConsumerkey(String consumerkey) {
         this.consumerkey = consumerkey;
     }
     public String getConsumerkey() {
         return consumerkey;
     }

    public void setConsumersecret(String consumersecret) {
         this.consumersecret = consumersecret;
     }
     public String getConsumersecret() {
         return consumersecret;
     }

    public void setSignaturemethod(String signaturemethod) {
         this.signaturemethod = signaturemethod;
     }
     public String getSignaturemethod() {
         return signaturemethod;
     }

    public void setAddemptyparamstosign(int addemptyparamstosign) {
         this.addemptyparamstosign = addemptyparamstosign;
     }
     public int getAddemptyparamstosign() {
         return addemptyparamstosign;
     }

    public void setIncludebodyhash(int includebodyhash) {
         this.includebodyhash = includebodyhash;
     }
     public int getIncludebodyhash() {
         return includebodyhash;
     }

    public void setAddparamstoheader(int addparamstoheader) {
         this.addparamstoheader = addparamstoheader;
     }
     public int getAddparamstoheader() {
         return addparamstoheader;
     }

    public void setRealm(String realm) {
         this.realm = realm;
     }
     public String getRealm() {
         return realm;
     }

    public void setVersion(String version) {
         this.version = version;
     }
     public String getVersion() {
         return version;
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

    public void setVerifier(String verifier) {
         this.verifier = verifier;
     }
     public String getVerifier() {
         return verifier;
     }

    public void setCallback(String callback) {
         this.callback = callback;
     }
     public String getCallback() {
         return callback;
     }

    public void setTokensecret(String tokensecret) {
         this.tokensecret = tokensecret;
     }
     public String getTokensecret() {
         return tokensecret;
     }

    public void setToken(String token) {
         this.token = token;
     }
     public String getToken() {
         return token;
     }

}