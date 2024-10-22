package testSuite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.todoly.NavBarSection;
import pages.todoly.ProjectLeftSection;
import pages.todoly.SettingsSection;

import org.openqa.selenium.JavascriptExecutor;
import session.Session;


import java.lang.invoke.SwitchPoint;
import java.util.Date;

public class ChangeFullNameTest extends BaseTestTodoLy{
    NavBarSection navBarSection = new NavBarSection();
    SettingsSection settingsSection = new SettingsSection();

    @Test
    public void createProject() throws InterruptedException {
        String name = "adios";
        mainPage.loginButton.click();
        loginSection.login("luisparicollo333@gmail.com","123456");
        navBarSection.settings.click();
        settingsSection.editFullName(name);
        Thread.sleep(7000);
        navBarSection.settings.click();
        String newName=settingsSection.fullNameInput.getPropertyValue("value");
        Assertions.assertEquals(name,newName,
                "ERROR the name was not changed");

    }


}
