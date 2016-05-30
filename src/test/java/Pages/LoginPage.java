package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

    private final String BASE_URL = "http://seasonvar.ru/?mod=login";
    private final String SETTINGS = "http://seasonvar.ru/?mod=settings";


    @FindBy(name = "login")
    private WebElement emailField;

    @FindBy(name = "password")
    private WebElement passField;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/ul/li[2]/div/div[2]/div/form/input[3]")
    private WebElement buttonSubmit;

    @FindBy(className = "login-cfg_name")
    private WebElement nickName;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div[1]/div/div[3]/input[1]")
    private WebElement newNickNameField;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div[1]/div/div[3]/input[2]") //.//*[@value='Сменить имя']
    private WebElement changeNickButton;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage(String URL) {
        driver.navigate().to(URL);
    }

    public void logIn(String email, String password) {
        openPage(BASE_URL);
        emailField.sendKeys(email);
        passField.sendKeys(password);
        buttonSubmit.click();
    }

    public boolean isLogIn() {
        return driver.findElement(By.className("login")).isDisplayed();
    }

    public void logOut() {
        driver.findElement(By.className("login")).click();
        driver.findElement(By.xpath(".//*[@href='/?mod=logout']")).click();
    }

    public boolean changeNick() {

        String newNick = (new RandomString()).createRandomString();
        openPage(SETTINGS);
        newNickNameField.sendKeys(newNick);
        changeNickButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return nickName.getText().equals(newNick);
    }


    public String getCurrentName() {
        openPage(SETTINGS);
        return nickName.getText();
    }


}
