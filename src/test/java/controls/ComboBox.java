package controls;


import org.openqa.selenium.By;

public class ComboBox extends AppiumControl {
    private String optionLabel="//android.widget.CheckedTextView[@text='%s']";
    public ComboBox(By locator) {
        super(locator);
    }

    public ComboBox(By locator, String optionLabel) {
        super(locator);
        this.optionLabel = optionLabel;
    }
    public void selectOption(String option){
        this.findControl();
        control.click();
        Label optionControl = new Label(By.xpath(String.format(optionLabel,option)));
        optionControl.click();
    }
}