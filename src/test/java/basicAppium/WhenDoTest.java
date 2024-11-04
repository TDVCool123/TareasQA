package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class WhenDoTest {

    AppiumDriver driver;

    @BeforeEach
    public void openApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName","TECNO SPARK 10C");
        capabilities.setCapability("appium:platformVersion","12");
        capabilities.setCapability("appium:appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appium:appActivity","com.vrproductiveapps.whendo.ui.HomeActivity");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appium:automationName","uiautomator2");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @AfterEach
    public void closeApp(){
    driver.quit();
    }

    @Test
    public void verifyCreateTarea() throws InterruptedException{
        String taskName= "TaskTest";
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(taskName);
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys("ashdsjahdas");
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();
        String result = driver.findElement(By.xpath("//android.widget.TextView[ @text='"+taskName+"']")).getText();
        Assertions.assertEquals(taskName,result,"Error: La tarea no fue creada ");


        Thread.sleep(5000);

    }
}
