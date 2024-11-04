package controls;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

import java.util.ArrayList;
import java.util.List;

public class AppiumControl {
    protected By locator;
    protected WebElement control;
    protected List<WebElement> controls;

    public AppiumControl(By locator){
        this.locator = locator;
    }

    protected void findControl(){
        control = Session.getInstance().getDevice().findElement(locator);
    }

    protected void findControls(){
        controls = Session.getInstance().getDevice().findElements(locator);
    }

    public void click(){
        findControl();
        control.click();
    }

    public String getText(){
        findControl();
        return control.getText();
    }

    public List<String> getTexts(){
        findControls();
        List<String> texts = new ArrayList<>();
        for (WebElement control : controls) {
            texts.add(control.getText());
        }
        return texts;
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