package pages.todoist;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class RegisterSection {
    public TextBox email = new TextBox(By.id("element-4"));
    public TextBox pass = new TextBox(By.id("element-6"));

    public Button registerButton = new Button(By.xpath("//span[text()='Registrarme con mi email']"));


}