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
        // Crear tareas con títulos en orden no alfabético
        String[] titles = {"Banana", "Apple", "Cherry", "Skibidi", "Nicole"};
        String notes = "Test note";

        for (String title : titles) {
            mainScreen.addButton.click();
            createTask.createTask(title, notes);
        }
        Arrays.sort(titles);
        // Obtener los títulos de las tareas desde la ListView
        List<String> taskTitles = mainScreen.getAllTaskTitles(titles);



        System.out.println(titles);
        //System.out.println(taskTitles);
        // Verificar que la lista de títulos esté en orden alfabético
        Assertions.assertEquals(titles, taskTitles,
                "ERROR: Las tareas no están en orden alfabético.");
    }
}
