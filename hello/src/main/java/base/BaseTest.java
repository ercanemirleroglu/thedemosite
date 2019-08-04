package base;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

public class BaseTest {

    private WebDriverWait webDriverWait;
    private String browser;
    private String driverPath;
    private String key;
    public final String chrome = "Chrome";
    public final String firefox = "Firefox";
    public final String chromeDriver = "\\chromedriver.exe";
    public final String firefoxDriver = "\\geckodriver.exe";
    public final String chromeKey = "webdriver.chrome.driver";
    public final String firefoxKey = "webdriver.gecko.driver";
    public String url = "http://thedemosite.co.uk/login.php";

    protected static final Logger log = Logger.getLogger("Log: ");


    public void chooseBrowser(String _browser){
        this.browser=_browser;
        if (this.browser.equalsIgnoreCase(chrome)){
            this.driverPath = chromeDriver;
            this.key = chromeKey;
            this.browser = chrome;

        }else if(this.browser.equalsIgnoreCase(firefox)){
            this.driverPath = firefoxDriver;
            this.key = firefoxKey;
            this.browser = firefox;
        }
    }

    public String sendDriverPath(){
        this.driverPath = System.getProperty("user.dir")+"\\drivers"+this.driverPath;
        return this.driverPath;
    }

    public void getDriver(String _browser){
        chooseBrowser(_browser);
        String path = sendDriverPath();
        System.setProperty(this.key, path);
        System.setProperty("selenide.browser", this.browser);
        Selenide.open(url);
        this.waitUntilUrlContains(url);
    }

    protected boolean waitUntilUrlContains(String expectedValue) {
        try {
            Wait<WebDriver> wait = (new FluentWait(WebDriverRunner.getWebDriver())).withTimeout(Duration.ofSeconds(30L)).pollingEvery(Duration.ofMillis(100L)).ignoring(StaleElementReferenceException.class).ignoring(NoSuchElementException.class);
            boolean urlExists = (Boolean)wait.until(ExpectedConditions.urlContains(expectedValue));
            if (urlExists) {
                log.info(expectedValue + " bulundu");
            }
            return true;
        } catch (Exception var4) {
            log.warning(expectedValue+ " bulunamadı");
            return false;
        }
    }
}
