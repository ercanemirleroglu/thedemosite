package Service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Login {

    @Test
    public void submitForm() {
        RestAssured.baseURI = "http://thedemosite.co.uk";

        Response response = given().urlEncodingEnabled(true)
                .param("username", "testuser")
                .param("password", "testpass")
                .header("Accept", ContentType.fromContentType("application/x-www-form-urlencoded"))
                .post("/login.php");

        int status = response.getStatusCode();

        if (status==200){
            String mesaj = response.getBody().asString();
            System.out.println(mesaj);
            System.out.println("Status code : " + status);
            if (mesaj.contains("**Successful Login**")){
                System.out.println("Login islemi **Basarili** bir sekilde gerceklesti");
            }else{
                System.out.println("Kullanici Adi veya Sifre yanlis girilmis!!");
                Assert.fail("Kullanici Adi veya Sifre yanlis girilmis!!");
            }
        }else{
            System.out.println("Servisten basarili bir sonuc donmedi. Status Code: " + status);
            Assert.fail("Servisten basarili bir sonuc donmedi. Status Code: " + status);
        }

    }
}