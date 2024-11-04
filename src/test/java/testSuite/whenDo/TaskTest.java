package testSuite.whenDo;


import activities.whendo.CreateTask;
import activities.whendo.MainScreen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest extends WhendoTestBase {
    MainScreen mainScreen = new MainScreen();
    CreateTask createTask = new CreateTask();
    @Test
    public void addTask(){
        String tittle = "New";
        String notes = "dsfrews";
        mainScreen.addButton.click();
        createTask.createTask(tittle,notes);

        Assertions.assertEquals(tittle,mainScreen.checkTaskTittle(tittle),
                "ERROR la suma es incorrecta");

    }
}