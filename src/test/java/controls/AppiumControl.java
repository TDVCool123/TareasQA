package controls;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

public class AppiumControl {
    protected By locator;
    protected WebElement control;

    public AppiumControl(By locator){
        this.locator = locator;
    }

    protected void findControl(){
        control = Session.getInstance().getDevice().findElement(locator);
    }

    public void click(){
        findControl();
        control.click();
    }

    public String getText(){
        findControl();
        return control.getText();
    }

    public boolean isControlDisplayed(){
        try {
            findControl();
            return control.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}