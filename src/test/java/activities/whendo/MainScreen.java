package activities.whendo;

import controls.Button;
import controls.Label;
import org.openqa.selenium.By;

public class MainScreen {
    public Button addButton = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));

    public Label boxLabel = new Label(By.xpath("//android.widget.ListView/android.view.ViewGroup/android.widget.LinearLayout"));

    public Label emptyTasksLabel = new Label(By.id("com.vrproductiveapps.whendo:id/noNotesText"));
    public String checkTittle(String tittle){
        return new Label(By.xpath("//android.widget.TextView[ @text='"+tittle+"']")).getText();
    }
}