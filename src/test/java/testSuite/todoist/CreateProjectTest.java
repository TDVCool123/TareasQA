package testSuite.todoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.todoist.CreateProjectSection;

import java.util.Date;

public class CreateProjectTest extends BaseTestTodoist{
    LoginTest loginTest = new LoginTest();
    CreateProjectSection createProjectSection = new CreateProjectSection();


    @Test
    public void createProject(){
        String projectName = "Luis Project";
        loginTest.verifyLoginSuccessfully();
        leftMenuSection.createProjectIconButton.click();
        leftMenuSection.createProjectButton.click();
        createProjectSection.createProject(projectName);

        Assertions.assertEquals(projectName,leftMenuSection.getProjectLabel(projectName).getText(),
                "ERROR the project was not created");

    }
}
