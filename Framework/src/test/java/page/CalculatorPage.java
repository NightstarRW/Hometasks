package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage extends AbstractPage {

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public CalculatorPage switchToCalculatorFrame() {
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        return this;
    }

    public CalculatorPage enterNumberOfInstances(String number) {
        WebElement input = new WebDriverWait(driver, 5).until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//*[contains(text(), 'Number of instances')]/../input")));
        input.sendKeys(String.valueOf(number));
        return this;
    }

    public CalculatorPage selectMachineType(String type) {
        scrollToElement(driver.findElement(By.xpath("//*[contains(text(), 'Machine type')]/..//md-select-value")));
        waitForElementIsClickableAndClickOnIt(By.xpath("//*[contains(text(), 'Machine type')]/..//md-select-value"));
        waitForElementIsClickableAndClickOnIt(By.xpath("//div[contains(text(), '" + type + "')]"));
        return this;
    }

    public CalculatorPage enterNumberOfNodes(String number) {
        WebElement input = new WebDriverWait(driver, 5).until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//*[contains(text(), 'Number of nodes')]/../input")));
        input.sendKeys(String.valueOf(number));
        return this;
    }

    public CalculatorPage addGPUs(String numberOfGPUs) {
        scrollToElement(driver.findElement(By.xpath("//div[contains(text(), 'Add GPUs')]/..")));
        waitForElementIsClickableAndClickOnIt(By.xpath("//div[contains(text(), 'Add GPUs')]/.."));
        waitForElementIsClickableAndClickOnIt(By.xpath("//*[contains(text(), 'Number of GPUs')]/..//md-select-value"));
        waitForElementIsClickableAndClickOnIt(By
                .xpath("//md-option[@value='" + numberOfGPUs + "'][@ng-value='item.value']"));
        return this;
    }

    public CalculatorPage selectGPUsType(String typeOfGPU) {
        scrollToElement(driver.findElement(By.xpath("//*[contains(text(), 'GPU type')]/..//md-select-value")));
        waitForElementIsClickableAndClickOnIt(By.xpath("//*[contains(text(), 'GPU type')]/..//md-select-value"));
        waitForElementIsClickableAndClickOnIt(By.xpath("//div[contains(text(), '" + typeOfGPU + "')]/.."));
        return this;
    }

    public CalculatorPage addLocalSSD() {
        scrollToElement(driver.findElement(By.xpath("//*[contains(text(), 'Local SSD')]/..//md-select-value")));
        waitForElementIsClickableAndClickOnIt(By.xpath("//*[contains(text(), 'Local SSD')]/..//md-select-value"));
        waitForElementIsClickableAndClickOnIt(By.xpath("//div[contains(text(), '24x375')]/.."));
        return this;
    }

    public CalculatorPage selectDatacenterLocation(String location) {
        scrollToElement(driver.findElement(By.xpath("(//*[contains(text(), 'Datacenter location')]/..//md-select-value)[2]")));
        waitForElementIsClickableAndClickOnIt(By.xpath("(//*[contains(text(), 'Datacenter location')]/..//md-select-value)[2]"));
        waitForElementIsClickableAndClickOnIt(By.xpath("(//md-option/div[contains(text(), '" + location + "')])[3]"));
        return this;
    }

    public CalculatorPage selectCommittedUsage(String usageYears) {
        scrollToElement(driver.findElement(By.xpath("(//*[contains(text(), 'Committed usage')]/..//md-select-value)[2]")));
        waitForElementIsClickableAndClickOnIt(By.xpath("(//*[contains(text(), 'Committed usage')]/..//md-select-value)[2]"));
        waitForElementIsClickableAndClickOnIt(By
                .xpath("//div[@id='select_container_126']//md-option[@value='" + usageYears + "']"));
        return this;
    }

    public CalculatorPage addInstanceToEstimate() {
        WebElement addInstanceToEstimateBtn = new WebDriverWait(driver, 5).until(ExpectedConditions
                .elementToBeClickable(By.xpath("(//button[contains(text(), 'Add to Estimate')])[1]")));
        scrollToElement(addInstanceToEstimateBtn);
        addInstanceToEstimateBtn.click();
        return this;
    }

    public CalculatorPage addNodeToEstimate() {
        WebElement addNodeToEstimateBtn = new WebDriverWait(driver, 5).until(ExpectedConditions
                .elementToBeClickable(By.xpath("(//button[contains(text(), 'Add to Estimate')])[2]")));
        scrollToElement(addNodeToEstimateBtn);
        addNodeToEstimateBtn.click();
        return this;
    }

    public String getTotalEstimatedCost() {
        return driver.findElement(By.xpath("//b[contains(text(), 'Total Estimated Cost')]")).getText();
    }

    public CalculatorPage initEmailEstimate() {
        WebElement emailEstimateBtn = new WebDriverWait(driver, 5).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[@id='email_quote']")));
        scrollToElement(emailEstimateBtn);
        emailEstimateBtn.click();
        return this;
    }

    public CalculatorPage pasteEmailAddress() {
        WebElement mailForm = new WebDriverWait(driver, 7).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//md-dialog")));
        scrollToElement(mailForm);
        mailForm.findElement(By.xpath("//input[@type='email']")).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "v"));
        return this;
    }

    public CalculatorPage sendMessageToEmail() {
        scrollToElement(driver.findElement(By.xpath("//button[contains(text(), 'Send Email')]")));
        waitForElementIsClickableAndClickOnIt(By.xpath("//button[contains(text(), 'Send Email')]"));
        return this;
    }
}
