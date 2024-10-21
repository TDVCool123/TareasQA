package testSuite;

import pages.todoly.LoginSection;
import pages.todoly.MainPage;
import pages.todoly.MenuSection;
import session.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTestTodoLy  {

    protected MainPage mainPage = new MainPage();
    protected LoginSection loginSection = new LoginSection();
    protected MenuSection menuSection = new MenuSection();


    @BeforeEach
    public void openBrowser(){
        Session.getInstance().getBrowser().get("https://todo.ly/");
    }

    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeSession();
    }


}