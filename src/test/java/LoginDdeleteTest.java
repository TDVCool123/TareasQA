import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginDdeleteTest {
    WebDriver chrome;

    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chrome/chromedriver-win64/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        chrome.manage().window().maximize();
        chrome.get("https://todo.ly/");
    }


    @AfterEach
    public void closeBrowser() {
        chrome.quit();
    }

    @Test
    @DisplayName("Verify login/delete test is succesfull")
    public void verifyLoginTest() throws InterruptedException {

        String proyect_to_delete="Luis Project";

        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("selenium123@123.com");
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        // borrar
        chrome.findElement(By.xpath("//td[@class=\"ProjItemContent\" and text()=\"Luis Project\"]//../td[@class=\"ItemIndicator\"]/div[@class=\"ProjItemMenu\"]/img[@src=\"/Images/dropdown.png\"]")).click();
        chrome.findElement(By.xpath("//a[@href=\"#delete\"]")).click();

        Thread.sleep(5000);
        Alert alert = chrome.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        Thread.sleep(5000);

        // verification edit
        int number = chrome.findElements(By.xpath("//td[@class=\"ProjItemContent\" and text()='"+proyect_to_delete+"'] ")).size();
        Assertions.assertTrue(chrome.findElements(By.xpath("//td[@class=\"ProjItemContent\" and text()='"+proyect_to_delete+"'] ")).size() == 0,
                "ERROR! nose pudo borrar el proyecto "+ number  +" " + text);
    }



}
