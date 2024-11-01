package activities.whendo;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class EditDeleteTask {
    public TextBox tittleTextBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));
    public TextBox noteTextBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextNotes"));

    public Button saveButton = new Button(By.id("com.vrproductiveapps.whendo:id/saveItem"));
    public Button deleteButton = new Button(By.id("com.vrproductiveapps.whendo:id/deleteItem"));

    public Button deleteConfirmation = new Button(By.id("android:id/button1"));

    public void editTask(String title, String note){
        tittleTextBox.clearSetText(title);
        noteTextBox.clearSetText(note);
        saveButton.click();
    }
    public void deleteTask(){
        deleteButton.click();
        deleteConfirmation.click();
    }
}

