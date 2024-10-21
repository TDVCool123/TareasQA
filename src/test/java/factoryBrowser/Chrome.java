package factoryBrowser;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Chrome implements IBrowser{
    @Override
    public WebDriver create() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        chrome.manage().window().maximize();
        return chrome;
    }

    @Test
    public void test1 (){

    }
}
