package pages.todoist;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class CreateProjectSection {
    public TextBox projectNameTxtBox = new TextBox(By.id("element-0"));

    public Button addButton = new Button(By.xpath("//button[@aria-disabled='false' and @type='submit']"));

    public void createProject(String projectName){
        projectNameTxtBox.setText(projectName);
        addButton.click();
    }
}
