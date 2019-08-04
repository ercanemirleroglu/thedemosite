package base;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginPage extends BaseTest{

    SelenideElement INP_USER_XPATH = $(By.xpath("//input[@name='username']"));
    SelenideElement INP_PASS_XPATH = $(By.xpath("//input[@name='password']"));
    SelenideElement A_LOGIN_XPATH = $(By.xpath("//input[@value='Test Login']"));

    //password
    public LoginPage login(String user, String pass) throws InterruptedException {
        signIn(user, pass);
        return this;
    }

    public void signIn(String user, String pass) throws InterruptedException {
        sleep(500); //Sonucun daha iyi görünebilmesi time-out ekleniyor
        INP_USER_XPATH.sendKeys(user);
        sleep(500);
        INP_PASS_XPATH.sendKeys(pass);
        sleep(500);
        A_LOGIN_XPATH.click();
    }

}
