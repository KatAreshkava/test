package createToken;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.*;

import javax.xml.bind.annotation.XmlRootElement;

import static io.restassured.RestAssured.*;


public class TestTokenCreated{
    private static String BASE_URL = "https://restful-booker.herokuapp.com";

    @Test
    public void testTokenCreated(){
        given().when().contentType(ContentType.JSON).body(Credentials.creds()).
                post(BASE_URL+"/auth").then().assertThat().statusCode(200);
        String resp = given().when().contentType(ContentType.JSON).body(Credentials.creds()).log().all().
                post(BASE_URL+"/auth").then().extract().response().asString();
        Assert.assertTrue(resp.contains("token"));
    }
}
