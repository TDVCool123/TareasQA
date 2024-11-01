package activities.calc;

import controls.Button;
import controls.Label;
import org.openqa.selenium.By;

public class MainScreen {
    public Button fourButton = new Button(By.id("com.android.calculator2:id/digit_4"));
    public Button eigthButton = new Button(By.xpath("//android.widget.Button[@text='8']"));
    public Button addButton = new Button(By.xpath("//android.widget.Button[@content-desc=\"plus\"]"));
    public Button equalButton = new Button(By.id("com.android.calculator2:id/eq"));
    public Label resultLabel = new Label(By.id("com.android.calculator2:id/result"));


}