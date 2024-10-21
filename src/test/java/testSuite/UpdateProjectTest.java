package testSuite;

import pages.todoly.ProjectLeftSection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class UpdateProjectTest extends  BaseTestTodoLy{
    ProjectLeftSection projectLeftSection = new ProjectLeftSection();
    @Test
    public void verifyUpdateProject(){
        String name = "UPB"+new Date().getTime();
        mainPage.loginButton.click();
        loginSection.login("luisparicollo333@gmail.com","123456");
        projectLeftSection.createProject(name);

        projectLeftSection.getProjectLabel(name).click();
        projectLeftSection.menuIcon.click();
        projectLeftSection.subMenuOptions.editButton.click();
        String newName = "TEST"+new Date().getTime();
        projectLeftSection.nameProjectEditTxtBox.clearSetText(newName);
        projectLeftSection.saveIcon.click();

        Assertions.assertEquals(newName,projectLeftSection.getProjectLabel(newName).getText(),
                "ERROR! the project was not updated" );

    }


}