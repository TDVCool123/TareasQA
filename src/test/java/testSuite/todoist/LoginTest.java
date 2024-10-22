package testSuite.todoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTestTodoist {
    @Test
    public void verifyLoginSuccessfully(){
        mainPage.loginButton.click();
        loginSection.login("luisandypp@gmail.com ","Qwerty12345");
        Assertions.assertTrue(leftMenuSection.profileButton.isControlDisplayed(),
                "ERROR! the login was failed");
    }
}