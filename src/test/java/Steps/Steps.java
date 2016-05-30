package Steps;

import Pages.LoginPage;
import Pages.MainPage;
import Pages.SerialPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Steps {
    private WebDriver driver;


    public void initBrowser() throws IOException {
        String file= "adblock.xpi";
        FirefoxProfile fp=new FirefoxProfile();
        fp.addExtension(new File(file));
        //  fp.setPreference("extensions.");
        driver = new FirefoxDriver(fp);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
    }

    public void closeDriver() {
        driver.close();
    }

    public void logIn(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(email, password);
    }

    public boolean isLoggedIn() {
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.isLogIn();
    }

    public boolean search(String serialName) {
        MainPage mainPage = new MainPage(driver);
        mainPage.search(serialName);
        return mainPage.isSearched();
    }

    public boolean logOut() {
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.isLogIn();
    }


    public boolean changeNick() {
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.changeNick();
    }

    public boolean addMark(String serialUrl) {
        SerialPage serialPage = new SerialPage(driver);
        return serialPage.addMark(serialUrl);
    }

    public boolean revomeMark(String serialUrl) {
        SerialPage serialPage = new SerialPage(driver);
        return serialPage.addMark(serialUrl);
    }

    public boolean wantSee(String serialUrl) {
        SerialPage serialPage = new SerialPage(driver);
        return serialPage.wantSee(serialUrl);
    }

    public boolean rusFilter() {
        MainPage mainPage = new MainPage(driver);
        return mainPage.selectRus();
    }

    public boolean enFilter() {
        MainPage mainPage = new MainPage(driver);
        return mainPage.selectEn();
    }

    public boolean allFilter() {
        MainPage mainPage = new MainPage(driver);
        return mainPage.selectAll();
    }

}
