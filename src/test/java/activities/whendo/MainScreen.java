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

    public Button sortButton = new Button (By.id("com.vrproductiveapps.whendo:id/home_header_icon"));
    public Button alfButton = new Button (By.xpath("//android.widget.CheckedTextView[4]"));

    public String checkTaskTittle(String tittle){
        return new Label(By.xpath("//android.widget.TextView[ @text='"+tittle+"']")).getText();
    }

    public Label entryTask(String tittle){
        return new Label(By.xpath("//android.widget.TextView[ @text='"+tittle+"']"));
    }

    public List<String> getAllTaskTitles(String[] expectedOrder) {
        List<String> taskTitles = new ArrayList<>();

        for (String title : expectedOrder) {
            try {
                String taskTitle = new Label(By.xpath("//android.widget.TextView[@resource-id='com.vrproductiveapps.whendo:id/home_list_item_text' and @text='" + title + "']")).getText();
                taskTitles.add(taskTitle);
            } catch (Exception e) {
                System.out.println("ERROR: No se encontró el título de tarea: " + title);
                return new ArrayList<>(); // Si falta un título, se devuelve una lista vacía
            }
        }

        // Devolvemos los títulos solo si están en el orden esperado
        return taskTitles.equals(List.of(expectedOrder)) ? taskTitles : new ArrayList<>();
    }
}