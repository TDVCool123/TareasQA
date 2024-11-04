package activities.whendo;

import controls.Button;
import controls.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MainScreen {
    public Button addButton = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));

    public Label emptyTasksLabel = new Label(By.id("com.vrproductiveapps.whendo:id/noNotesText"));
    public String checkTaskTittle(String tittle){
        return new Label(By.xpath("//android.widget.TextView[ @text='"+tittle+"']")).getText();
    }

    public Label entryTask(String tittle){
        return new Label(By.xpath("//android.widget.TextView[ @text='"+tittle+"']"));
    }

    public List<String> getAllTaskTitles(String[] names) {
        String title = new Label(By.xpath("//android.widget.TextView[@resource-id=\"com.vrproductiveapps.whendo:id/home_list_item_text\" and @text='"+names[0]+"']")).getText();
        return null;
    }
}