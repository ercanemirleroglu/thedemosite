package Screen;

import base.BaseTest;
import base.LoginPage;
import base.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import users.User;

public class LoginOlma extends BaseTest {
    User user = new User();
    @BeforeMethod
    public void BeforeTest(){
        String browser="Chrome";
        getDriver(browser);
    }

    @Test(enabled = true, description= "Siteye Login olup olmadığının kontrolü")
    public void TS0001_Login() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        loginPage.login(user.ercanUser, user.ercanPass);
        mainPage.loginStatuControl();
    }

}
