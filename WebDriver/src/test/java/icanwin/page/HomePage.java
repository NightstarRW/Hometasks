package icanwin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;

    @FindBy(id = "postform-name")
    private WebElement pasteName;

    @FindBy(id = "postform-text")
    private WebElement pasteCode;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createPasteButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage openPage(String url) {
        driver.get(url);
        return this;
    }

    public HomePage enterPasteName(String name) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(pasteName)).sendKeys(name);
        return this;
    }

    public HomePage enterPasteCode(String code) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(pasteCode)).sendKeys(code);
        return this;
    }

    public HomePage setPasteExpirationOnTenMinutes() {
        WebElement pasteExpiration = new WebDriverWait(driver, 5).until(ExpectedConditions.
                elementToBeClickable(By.id("select2-postform-expiration-container")));
        pasteExpiration.click();
        WebElement expirationsBox = driver.findElement(By.id("select2-postform-expiration-results"));
        expirationsBox.findElement(By.xpath("//li[text()='10 Minutes']")).click();
        return this;
    }

    public HomePage createPaste() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createPasteButton);
        createPasteButton.click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.
                presenceOfElementLocated(By.className("info-bar")));
        return this;
    }
}
