package postman.apipost.convert.postman2apipost.apipost;
import com.alibaba.fastjson.annotation.JSONField;
/**
 * Auto-generated: 2022-12-29 14:22:13
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Ntlm {

    private String username;
    private String password;
    private String domain;
    private String workstation;
    @JSONField(name = "disableRetryRequest")
    private int disableretryrequest;
    public void setUsername(String username) {
         this.username = username;
     }
     public String getUsername() {
         return username;
     }

    public void setPassword(String password) {
         this.password = password;
     }
     public String getPassword() {
         return password;
     }

    public void setDomain(String domain) {
         this.domain = domain;
     }
     public String getDomain() {
         return domain;
     }

    public void setWorkstation(String workstation) {
         this.workstation = workstation;
     }
     public String getWorkstation() {
         return workstation;
     }

    public void setDisableretryrequest(int disableretryrequest) {
         this.disableretryrequest = disableretryrequest;
     }
     public int getDisableretryrequest() {
         return disableretryrequest;
     }

}