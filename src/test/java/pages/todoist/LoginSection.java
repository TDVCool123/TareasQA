package pages.todoist;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class LoginSection {
    public Button register = new Button(By.xpath("//a[text()='Regístrate']"));

    public TextBox email = new TextBox(By.id("element-0"));
    public TextBox pass = new TextBox(By.id("element-2"));

    public Button loginButton = new Button(By.xpath("//button[@data-gtm-id='start-email-login']"));

    public void login(String email, String pwd){
        this.email.setText(email);
        this.pass.setText(pwd);
        this.loginButton.click();
    }

}