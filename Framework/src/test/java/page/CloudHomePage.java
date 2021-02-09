package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CloudHomePage extends AbstractPage {

    @FindBy(name = "q")
    private WebElement searchField;

    public CloudHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CloudHomePage openPage(String url) {
        driver.get(url);
        return this;
    }

    public CloudHomePage searchForTerm(String term) {
        searchField.sendKeys(term);
        searchField.sendKeys(Keys.ENTER);
        return this;
    }

    public CalculatorPage goToTheFirstSearchResult() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//div[@class='gsc-webResult gsc-result']")));
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='gsc-webResult gsc-result']"));
        searchResults.get(0).findElement(By.xpath("//a[@class='gs-title']")).click();
        new WebDriverWait(driver, 15).until(
                driver -> ((JavascriptExecutor) driver).
                        executeScript("return document.readyState").equals("complete"));
        return new CalculatorPage(driver);
    }
}
