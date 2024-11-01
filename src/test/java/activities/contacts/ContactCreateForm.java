package activities.contacts;

import controls.Button;
import controls.ComboBox;
import controls.TextBox;
import org.openqa.selenium.By;

public class ContactCreateForm {
    public TextBox nameTxtBox = new TextBox(By.xpath("//android.widget.EditText[@text=\"First name\"]"));
    public TextBox lastNameTxtBox = new TextBox(By.xpath("//android.widget.EditText[@text=\"Last name\"]"));
    public TextBox phoneTxtBox = new TextBox(By.xpath("//android.widget.EditText[@text=\"Phone\"]"));

    public ComboBox typePhone = new ComboBox(By.xpath("//android.widget.TextView[@text='Mobile']"));
    public Button saveButton = new Button(By.id("com.android.contacts:id/editor_menu_save_button"));

}