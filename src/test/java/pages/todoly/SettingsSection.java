package pages.todoly;


import controls.Button;
import controls.Icon;
import controls.Label;
import controls.TextBox;
import org.openqa.selenium.By;

public class SettingsSection {
    public TextBox fullNameInput = new TextBox(By.id("FullNameInput"));
    public Button okButton = new Button(By.xpath("//span[text()='Ok']")) ;
    public void editFullName(String name) throws InterruptedException {
        fullNameInput.clearSetText(name);
        Thread.sleep(3000);
        okButton.click();
        Thread.sleep(3000);


    }
}
