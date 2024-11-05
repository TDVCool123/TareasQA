package testSuite.whenDo;

import activities.whendo.CreateTask;
import activities.whendo.MainScreen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortTest extends WhendoTestBase {
    MainScreen mainScreen = new MainScreen();
    CreateTask createTask = new CreateTask();

    @Test
    public void verifyAlphabeticalOrder() {
        String[] titles = {"Apple","sfdfdsfs", "Banana"};
        String notes = "Test note";

        for (String title : titles) {
            mainScreen.addButton.click();
            createTask.createTask(title, notes);
        }
        mainScreen.sortButton.click();
        mainScreen.alfButton.click();

        List<String> taskTitles = mainScreen.getAllTaskTitles(titles);
        Arrays.sort(titles);

        System.out.println(titles);
        System.out.println(taskTitles);
        Assertions.assertEquals(Arrays.asList(titles), taskTitles,
                "ERROR: Las tareas no están en orden alfabético.");
        
    }
}
