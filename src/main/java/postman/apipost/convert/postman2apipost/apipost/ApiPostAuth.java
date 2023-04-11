package postman.apipost.convert.postman2apipost.apipost;

/**
 * Auto-generated: 2022-12-29 14:22:13
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class ApiPostAuth {

    private String type;
    private Kv kv;
    private ApiPostAuthBearer apiPostAuthBearer;
    private Basic basic;
    private Digest digest;
    private Hawk hawk;
    private Awsv4 awsv4;
    private Ntlm ntlm;
    private Edgegrid edgegrid;
    private Oauth1 oauth1;
    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

    public void setKv(Kv kv) {
         this.kv = kv;
     }
     public Kv getKv() {
         return kv;
     }

    public void setBearer(ApiPostAuthBearer apiPostAuthBearer) {
         this.apiPostAuthBearer = apiPostAuthBearer;
     }
     public ApiPostAuthBearer getBearer() {
         return apiPostAuthBearer;
     }

    public void setBasic(Basic basic) {
         this.basic = basic;
     }
     public Basic getBasic() {
         return basic;
     }

    public void setDigest(Digest digest) {
         this.digest = digest;
     }
     public Digest getDigest() {
         return digest;
     }

    public void setHawk(Hawk hawk) {
         this.hawk = hawk;
     }
     public Hawk getHawk() {
         return hawk;
     }

    public void setAwsv4(Awsv4 awsv4) {
         this.awsv4 = awsv4;
     }
     public Awsv4 getAwsv4() {
         return awsv4;
     }

    public void setNtlm(Ntlm ntlm) {
         this.ntlm = ntlm;
     }
     public Ntlm getNtlm() {
         return ntlm;
     }

    public void setEdgegrid(Edgegrid edgegrid) {
         this.edgegrid = edgegrid;
     }
     public Edgegrid getEdgegrid() {
         return edgegrid;
     }

    public void setOauth1(Oauth1 oauth1) {
         this.oauth1 = oauth1;
     }
     public Oauth1 getOauth1() {
         return oauth1;
     }

}