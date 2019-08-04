package base;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BaseTest{
    BaseTest baseTest = new BaseTest();

    SelenideElement B_STATU_XPATH = $(By.xpath("//div[starts-with(text(), 'All code updated')]/../big//b"));

    public MainPage loginStatuControl(){
        String statu = "";
        statu = B_STATU_XPATH.getText();
        if(statu!=""){
            if (statu.contains("Successful")){
                System.out.println(statu);
                log.info("Login olma islemi basarili");
            }else{
                log.warning("Login olma islemi basarisiz. User pass bilgilerini kontrol ediniz");
                Assert.fail("Login olma islemi basarisiz. User pass bilgilerini kontrol ediniz");
            }
        }else{
            log.warning("Statu kodu sayfadan alınamadı");
            Assert.fail("Statu kodu sayfadan alınamadı");
        }
        return this;
    }


}
