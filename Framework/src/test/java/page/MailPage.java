package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends AbstractPage {

    public MailPage(WebDriver driver) {
        this.driver = driver;
    }

    public MailPage openMailPage() {
        driver.get("https://10minutemail.com/");
        new WebDriverWait(driver, 20).until(
                driver -> ((JavascriptExecutor) driver).
                        executeScript("return document.readyState").equals("complete"));
        return this;
    }

    public void copyEmailAddress() {
        waitForElementIsClickableAndClickOnIt(By.id("copy_address"));
        driver.findElement(By.id("mail_address"))
                .sendKeys(Keys.chord(Keys.LEFT_CONTROL, "c"));
    }

    public MailPage waitForMessageAndOpenIt(int messageTimeOut) {
        WebElement emailMessage = new WebDriverWait(driver, messageTimeOut).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[@id='mail_messages_content']/div/div[1]")));
        emailMessage.click();
        return this;
    }

    public String getCostFromMessage() {
        WebElement messageBox = new WebDriverWait(driver, 7).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[@id='mail_messages_content']/div/div[2]")));
        scrollToElement(messageBox);
        WebElement cost = new WebDriverWait(driver, 5).until(ExpectedConditions
                .visibilityOf(messageBox.findElement(By.xpath("//*[contains(text(), 'Estimated Monthly Cost')]"))));
        return cost.getText();
    }
}
