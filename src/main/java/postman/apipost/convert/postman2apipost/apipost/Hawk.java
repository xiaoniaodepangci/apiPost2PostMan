package postman.apipost.convert.postman2apipost.apipost;

import com.alibaba.fastjson.annotation.JSONField;
/**
 * Auto-generated: 2022-12-29 14:22:13
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Hawk {

    @JSONField(name = "authId")
    private String authid;
    @JSONField(name = "authKey")
    private String authkey;
    private String algorithm;
    private String user;
    private String nonce;
    @JSONField(name = "extraData")
    private String extradata;
    private String app;
    private String delegation;
    private String timestamp;
    @JSONField(name = "includePayloadHash")
    private int includepayloadhash;
    public void setAuthid(String authid) {
         this.authid = authid;
     }
     public String getAuthid() {
         return authid;
     }

    public void setAuthkey(String authkey) {
         this.authkey = authkey;
     }
     public String getAuthkey() {
         return authkey;
     }

    public void setAlgorithm(String algorithm) {
         this.algorithm = algorithm;
     }
     public String getAlgorithm() {
         return algorithm;
     }

    public void setUser(String user) {
         this.user = user;
     }
     public String getUser() {
         return user;
     }

    public void setNonce(String nonce) {
         this.nonce = nonce;
     }
     public String getNonce() {
         return nonce;
     }

    public void setExtradata(String extradata) {
         this.extradata = extradata;
     }
     public String getExtradata() {
         return extradata;
     }

    public void setApp(String app) {
         this.app = app;
     }
     public String getApp() {
         return app;
     }

    public void setDelegation(String delegation) {
         this.delegation = delegation;
     }
     public String getDelegation() {
         return delegation;
     }

    public void setTimestamp(String timestamp) {
         this.timestamp = timestamp;
     }
     public String getTimestamp() {
         return timestamp;
     }

    public void setIncludepayloadhash(int includepayloadhash) {
         this.includepayloadhash = includepayloadhash;
     }
     public int getIncludepayloadhash() {
         return includepayloadhash;
     }

}