import Steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class AutoTests {
    private final String EMAIL = "testirovshik3k@trashmail.com";
    private final String PASSWORD = "testirovshik3k@trashmail.com";
    private final String SERIALNAME = "Шерлок";
    private final String URL_SerialPage = "http://seasonvar.ru/serial-1550-Doktor_Haus-7-season.html";
    private Steps steps;

    @BeforeMethod(description = "Init browser")
    public void setUp() throws IOException {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test(priority = 1)
    public void logIn() {
        steps.logIn(EMAIL, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn());
    }

    @Test(priority = 2)
    public void search() {
        steps.logIn(EMAIL, PASSWORD);
        Assert.assertTrue(steps.search(SERIALNAME));
    }

    @Test(priority = 3)
    public void logOut() {
        steps.logIn(EMAIL, PASSWORD);
        Assert.assertTrue(steps.logOut());
    }

    @Test(priority = 4)
    public void changeNick() {
        steps.logIn(EMAIL, PASSWORD);
        Assert.assertTrue(steps.changeNick());
    }

    @Test(priority = 5)
    public void addMark() {
        steps.logIn(EMAIL, PASSWORD);
        Assert.assertTrue(steps.addMark(URL_SerialPage));
    }
/*
    @Test(priority = 6)
    public void removeMark() {
        steps.logIn(EMAIL, PASSWORD);
        Assert.assertTrue(steps.revomeMark(URL_SerialPage));
    }


    @Test(priority = 7)
    public void wantSee() {
        steps.logIn(EMAIL, PASSWORD);
        Assert.assertTrue(steps.wantSee(URL_SerialPage));
    }

    @Test(priority = 8)
    public void checkRusFilter() {
        steps.logIn(EMAIL, PASSWORD);
        Assert.assertTrue(steps.rusFilter());
    }

    @Test(priority = 9)
    public void checkEnFilter() {
        steps.logIn(EMAIL, PASSWORD);
        Assert.assertTrue(steps.enFilter());
    }

    @Test(priority = 10)
    public void checkAllFilter() {
        steps.logIn(EMAIL, PASSWORD);
        Assert.assertTrue(steps.allFilter());
    }*
   /* @Test(priority=5)
    public void addComment(){
        steps.logIn(EMAIL, PASSWORD);
        Assert.assertTrue(steps.addComment());
    }*/

    @AfterMethod(description = "Close browser")
    public void closeBrowser() {
        steps.closeDriver();
    }
}
