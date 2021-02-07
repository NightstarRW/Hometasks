package hardcore.page;

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

    public CalculatorPage enterNumberOfInstances(int number) {
        WebElement input = new WebDriverWait(driver, 5).until(ExpectedConditions.
                presenceOfElementLocated(By.id("input_63")));
        input.sendKeys(String.valueOf(number));
        return this;
    }

    public CalculatorPage selectMachineType(String type) {
        waitForElementIsClickableAndClickOnIt(By.id("select_value_label_60"));
        waitForElementIsClickableAndClickOnIt(By.xpath("//div[contains(text(), '" + type + "')]"));
        return this;
    }

    public CalculatorPage enterNumberOfNodes(int number) {
        WebElement input = new WebDriverWait(driver, 5).until(ExpectedConditions.
                presenceOfElementLocated(By.id("input_105")));
        input.sendKeys(String.valueOf(number));
        return this;
    }

    public CalculatorPage addGPUs(int numberOfGPUs) {
        waitForElementIsClickableAndClickOnIt(By.xpath("//div[contains(text(), 'Add GPUs')]/.."));
        waitForElementIsClickableAndClickOnIt(By.xpath("//*[@id='select_value_label_352']/span[1]"));
        waitForElementIsClickableAndClickOnIt(By
                .xpath("//md-option[@value='" + numberOfGPUs + "'][@ng-value='item.value']"));
        return this;
    }

    public CalculatorPage selectGPUsType(String typeOfGPU) {
        waitForElementIsClickableAndClickOnIt(By.xpath("//*[@id='select_value_label_353']/span[1]"));
        WebElement typeGPUBox = driver.findElement(By.xpath("//div[contains(text(), '" + typeOfGPU + "')]/../../.."));
        WebElement gpu = new WebDriverWait(driver, 5).
                until(ExpectedConditions.elementToBeClickable(typeGPUBox.
                        findElement(By.xpath("//*[@id='select_option_364']"))));
        gpu.click();
        return this;
    }

    public CalculatorPage addLocalSSD() {
        waitForElementIsClickableAndClickOnIt(By.xpath("//*[@id='select_value_label_102']/span[1]"));
        WebElement ssdBox = driver.findElement(By.xpath("//*[@id='select_container_119']/md-select-menu/md-content"));
        WebElement ssd = new WebDriverWait(driver, 5).until(ExpectedConditions
                .elementToBeClickable(ssdBox.findElement(By.xpath("//div[contains(text(), '24x375')]/.."))));
        ssd.click();
        return this;
    }

    public CalculatorPage selectDatacenterLocation(String location) {
        waitForElementIsClickableAndClickOnIt(By.xpath("//*[@id='select_value_label_103']/span[1]"));
        WebElement datacenterBox = driver.findElement(By.id("select_container_121"));
        WebElement datacenter = new WebDriverWait(driver, 5).until(ExpectedConditions
                .elementToBeClickable(datacenterBox.
                        findElement(By.xpath("(//md-option/div[contains(text(), '" + location + "')])[3]"))));
        datacenter.click();
        return this;
    }

    public CalculatorPage selectCommittedUsage(int usageYears) {
        waitForElementIsClickableAndClickOnIt(By.xpath("//*[@id='select_value_label_104']/span[1]"));
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
        waitForElementIsClickableAndClickOnIt(By.xpath("//button[contains(text(), 'Send Email')]"));
        return this;
    }
}
