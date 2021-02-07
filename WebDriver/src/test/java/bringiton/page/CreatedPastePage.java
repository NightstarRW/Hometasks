package bringiton.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatedPastePage {
    private final WebDriver driver;

    @FindBy(xpath = "//div[@class='info-top']/h1")
    private WebElement pasteName;

    @FindBy(xpath = "//textarea")
    private WebElement pasteCode;

    @FindBy(xpath = "//div[@class='left']/a")
    private WebElement pasteSyntax;

    public CreatedPastePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPasteName() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(pasteName));
        return pasteName.getText();
    }

    public String getPasteSyntax() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(pasteSyntax));
        return pasteSyntax.getText();
    }

    public String getPasteCode() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(pasteCode));
        return pasteCode.getText();
    }
}
