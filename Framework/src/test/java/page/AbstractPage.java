package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;

    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).
                executeScript("arguments[0].scrollIntoView({block: \"center\"})", element);
    }

    protected void waitForElementIsClickableAndClickOnIt(By selector) {
        WebElement element = new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(selector));
        element.click();
    }

    protected void scrollAndClickOnElement(By selector) {
        WebElement element = new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(selector));
        scrollToElement(element);
        element.click();
    }
}
