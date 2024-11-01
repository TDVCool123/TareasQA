package testSuite.whenDo;


import activities.whendo.CreateTask;
import activities.whendo.EditDeleteTask;
import activities.whendo.MainScreen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddUpdateDeleteTaskTest extends WhendoTestBase {
    MainScreen mainScreen = new MainScreen();
    CreateTask createTask = new CreateTask();

    EditDeleteTask editDeleteTask =new EditDeleteTask();

    @Test
    public void CUDTask(){
        //create
        String tittle = "UwU";
        String notes = "Sigma";
        mainScreen.addButton.click();
        createTask.createTask(tittle,notes);

        //edit
        String newtittle = "Skibidi";
        String newNote = "Skibidi sigma pomni digital fortnite chamba";
        mainScreen.boxLabel.click();
        editDeleteTask.editTask(newtittle, newNote);
        mainScreen.boxLabel.click();
        editDeleteTask.deleteTask();

        //check
        String expectedResult = "No se agregaron tareas";

        Assertions.assertEquals(expectedResult,mainScreen.emptyTasksLabel.getText(),
                "ERROR no se hizo el flujo bien");

    }
}