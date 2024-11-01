package activities.whendo;


import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class CreateTask {
    public TextBox tittleTextBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));
    public TextBox noteTextBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextNotes"));
    public Button saveButton = new Button(By.id("com.vrproductiveapps.whendo:id/saveItem"));
    
    public void createTask (String tittle, String note){
        tittleTextBox.setText(tittle);
        noteTextBox.setText(note);
        saveButton.click();
    }
}
