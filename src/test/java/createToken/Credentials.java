package createToken;

import org.json.JSONObject;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "creds")
public class Credentials implements Serializable {
    private static String user = "admin";
    private static String password = "password123";

    public static String creds(){
        JSONObject cred = new JSONObject();
        cred.put("username", user);
        cred.put("password",password);
        return cred.toString();
    }
}
