import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class LoginCreateEditTestFire {
    WebDriver firefox;

    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.firefox.driver","src/test/resources/firefox/geckodriver.exe");
        firefox = new FirefoxDriver();
        firefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        firefox.manage().window().maximize();
        firefox.get("https://todo.ly/");
    }


    @AfterEach
    public void closeBrowser() {
        firefox.quit();
    }

    @Test
    @DisplayName("Verify login/creare/edit test is succesfull")
    public void verifyLoginTest() throws InterruptedException {
        firefox.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        firefox.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("selenium123@123.com");
        firefox.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        firefox.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        //Crear
        firefox.findElement(By.xpath("//div[@class=\"AddProjectLiDiv\"]")).click();
        firefox.findElement(By.id("NewProjNameInput")).sendKeys("Luis Firefox");
        firefox.findElement(By.id("NewProjNameButton")).click();

        // verification crear
        Assertions.assertTrue(firefox.findElements(By.xpath("//td[@class=\"ProjItemContent\" and text()=\"Luis Firefox\"]")).size() >0,
                "ERROR! nose pudo iniciar sesion");


        //Editar
        firefox.findElement(By.xpath("//td[@class=\"ProjItemContent\" and text()=\"Luis Firefox\"]//../td[@class=\"ItemIndicator\"]/div[@class=\"ProjItemMenu\"]/img[@src=\"/Images/dropdown.png\"]")).click();
        // click menu icon
        firefox.findElement(By.xpath("//a[@href=\"#edit\"]")).click();
        firefox.findElement(By.id("ItemEditTextbox")).clear();
        firefox.findElement(By.id("ItemEditTextbox")).sendKeys("Luis Firefox edit");
        firefox.findElement(By.id("ItemEditSubmit")).click();


        // verification edit
        Assertions.assertTrue(firefox.findElements(By.xpath("//td[@class=\"ProjItemContent\" and text()=\"Project edit\"]")).size() >0,
                "ERROR! nose pudo iniciar sesion");
    }



}
