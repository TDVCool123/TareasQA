package activities.alarma;

import controls.Button;
import controls.Label;
import org.openqa.selenium.By;

public class AlarmMainScreen {
    public Button addAlarmButton = new Button(By.xpath("//android.widget.ImageView[@resource-id='com.transsion.deskclock:id/fab']"));

    public Label timeLabel = new Label(By.id("com.transsion.deskclock:id/textClock"));



    /*public String checkLabel(String time){
        String formattedTime = time.replace("a.m.", "\u200Aa.\u00A0m.");

        String xpath = String.format("//android.widget.TextView[@content-desc='%s']", formattedTime);

        return new Label(By.xpath(xpath)).getText();
    }*/
    public String getAlarmText(String time){
        return new Label(By.xpath("//android.widget.TextView[@text='"+time+"']")).getText();
    }



}
