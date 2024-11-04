package activities.alarma;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class AddAlarmScreen {
    public TextBox hourWheel = new TextBox(By.id("com.transsion.deskclock:id/hourWheel"));
    public TextBox minWheel = new TextBox(By.id("com.transsion.deskclock:id/minWheel"));
    public TextBox formatWheel = new TextBox(By.id("com.transsion.deskclock:id/formatWheel"));

    public Button saveAlarm = new Button(By.id("com.transsion.deskclock:id/save_alarm"));

    public void setHour(String hour, String min, String format){
        hourWheel.setText(hour);
        minWheel.setText(min);
        formatWheel.setText(format);
    }

}
