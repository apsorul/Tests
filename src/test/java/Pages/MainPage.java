package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
    private final String BASE_URL = "http://seasonvar.ru/";


    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(className = "form-searchnew")
    private WebElement searchButton;

    @FindBy(id = "all_search_results")
    private WebElement search_results;

    @FindBy(xpath = ".//*[@value='rus']")
    private WebElement rusFilter;

    @FindBy(xpath = ".//*[@value='all']")
    private WebElement allFilter;

    @FindBy(xpath = ".//*[@value='eng']")
    private WebElement engFilter;

    @FindBy(id = "showRes")
    private WebElement applyFilter;

    @FindBy(id = "countFound")
    private WebElement countField;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage(String URL) {
        driver.navigate().to(URL);
    }


    public void search(String serialName) {
        searchField.sendKeys(serialName);
        searchButton.click();
    }

    public boolean isSearched() {
        return driver.findElement(By.className("searchResult")).isDisplayed();
    }

    public boolean selectRus() {
        rusFilter.click();
        String before = countField.getText();
        applyFilter.click();
        return !before.equals(countField.getText());
    }

    public boolean selectEn() {
        engFilter.click();
        String before = countField.getText();
        applyFilter.click();
        return !before.equals(countField.getText());
    }

    public boolean selectAll() {
        engFilter.click();
        applyFilter.click();
        String before = countField.getText();

        allFilter.click();
        applyFilter.click();

        return !before.equals(countField.getText());
    }

}
