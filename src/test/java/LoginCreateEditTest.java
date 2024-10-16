import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginCreateEditTest {
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
    @DisplayName("Verify login/creare/edit test is succesfull")
    public void verifyLoginTest() throws InterruptedException {
        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("selenium123@123.com");
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        //Crear
        chrome.findElement(By.xpath("//div[@class=\"AddProjectLiDiv\"]")).click();
        chrome.findElement(By.id("NewProjNameInput")).sendKeys("Project");
        chrome.findElement(By.id("NewProjNameButton")).click();

        // verification crear
        Assertions.assertTrue(chrome.findElements(By.xpath("//td[@class=\"ProjItemContent\" and text()=\"Project\"]")).size() >0,
                "ERROR! nose pudo iniciar sesion");


        //Editar
        chrome.findElement(By.xpath("//td[@class=\"ProjItemContent\" and text()=\"Project\"]//../td[@class=\"ItemIndicator\"]/div[@class=\"ProjItemMenu\"]/img[@src=\"/Images/dropdown.png\"]")).click();
        chrome.findElement(By.xpath("//a[@href=\"#edit\"]")).click();
        chrome.findElement(By.id("ItemEditTextbox")).clear();
        chrome.findElement(By.id("ItemEditTextbox")).sendKeys("Project edit");
        chrome.findElement(By.id("ItemEditSubmit")).click();


        // verification edit
        Assertions.assertTrue(chrome.findElements(By.xpath("//td[@class=\"ProjItemContent\" and text()=\"Project edit\"]")).size() >0,
                "ERROR! nose pudo iniciar sesion");
    }



}
