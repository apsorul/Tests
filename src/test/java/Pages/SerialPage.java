package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SerialPage extends AbstractPage {

    @FindBy(className = "svPlayBtn-addMark")
    private WebElement addMarkSeria;

    @FindBy(className = "delete")
    private WebElement deleteMarkSeria;

    @FindBy(xpath = ".//*[@href='/?mod=pause']")
    private WebElement bookmarksButt;

    @FindBy(className = "svPlayBtn-wantSee")
    private WebElement wantSeeButt;

    @FindBy(className = "svPlayBtn-htmlPlay")
    private WebElement HTML5Button;

    @FindBy(id = "htmlPlayer")
    private WebElement videoPlayer;

    @FindBy(id = "delHis")
    private WebElement delHisButton;

    public SerialPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


    @Override
    public void openPage(String URL) {
        driver.navigate().to(URL);
    }

    public boolean addMark(String serialUrl) {
        openPage(serialUrl);
        addMarkSeria.click();
        bookmarksButt.click();
        boolean isAdd = driver.findElement(By.className("mark_col")).isDisplayed();
        clickDeleteButton();
        return isAdd;
    }

    public boolean removeMark(String serialUrl) {
        openPage(serialUrl);
        addMarkSeria.click();
        bookmarksButt.click();
        if (driver.findElement(By.className("mark_col")).isDisplayed()) clickDeleteButton();
        ;
        return !driver.findElement(By.className("mark_col")).isDisplayed();
    }

    public boolean wantSee(String serialUrl) {
        openPage(serialUrl);
        wantSeeButt.click();
        bookmarksButt.click();
        boolean isAdd = driver.findElement(By.className("mark_col")).isDisplayed();
        clickDeleteButton();
        return isAdd;
    }

    /*
        public boolean checkHistory(String serialUrl){
            openPage(serialUrl);
            HTML5Button.click();
            JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
            jsExecutor.executeScript("return arguments[0].start()", videoPlayer);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            openPage("http://seasonvar.ru/?mod=history");
            boolean isWork = historyField.isDisplayed();
            delHisButton.submit();
            return isWork;
        }
    */
    private void clickDeleteButton() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", deleteMarkSeria);
    }


}

