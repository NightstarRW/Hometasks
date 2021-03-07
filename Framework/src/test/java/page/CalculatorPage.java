package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage extends AbstractPage {
    private static final By NUMBER_OF_INSTANCES_BOX = By.xpath("//*[contains(text(), 'Number of instances')]/../input");
    private static final By MACHINE_TYPE_BOX = By.xpath("//*[contains(text(), 'Machine type')]/..//md-select-value");
    private static final By NUMBER_OF_NODES_INPUT = By.xpath("//*[contains(text(), 'Number of nodes')]/../input");
    private static final By ADD_GPU_CHECK_BOX = By.xpath("//div[contains(text(), 'Add GPUs')]/..");
    private static final By ADD_GPU_BOX = By.xpath("//*[contains(text(), 'Number of GPUs')]/..//md-select-value");
    private static final By SELECT_GPU_TYPE_BOX = By.xpath("//*[contains(text(), 'GPU type')]/..//md-select-value");
    private static final By ADD_LOCAL_SSD_BOX = By.xpath("//*[contains(text(), 'Local SSD')]/..//md-select-value");
    private static final By DATACENTER_LOCATION_BOX = By
            .xpath("(//*[contains(text(), 'Datacenter location')]/..//md-select-value)[2]");
    private static final By COMMITTED_USAGE_BOX = By
            .xpath("(//*[contains(text(), 'Committed usage')]/..//md-select-value)[2]");
    private static final By ADD_INSTANCE_TO_ESTIMATE_BUTTON = By
            .xpath("(//button[contains(text(), 'Add to Estimate')])[1]");
    private static final By ADD_NODE_TO_ESTIMATE_BUTTON = By
            .xpath("(//button[contains(text(), 'Add to Estimate')])[2]");
    private static final By INIT_EMAIL_ESTIMATE_BUTTON = By.xpath("//button[@id='email_quote']");
    private static final By SEND_MESSAGE_TO_EMAIL_BUTTON = By.xpath("//button[contains(text(), 'Send Email')]");

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
                presenceOfElementLocated(NUMBER_OF_INSTANCES_BOX));
        input.sendKeys(String.valueOf(number));
        return this;
    }

    public CalculatorPage selectMachineType(String type) {
        scrollAndClickOnElement(MACHINE_TYPE_BOX);
        waitForElementIsClickableAndClickOnIt(By.xpath("//div[contains(text(), '" + type + "')]"));
        return this;
    }

    public CalculatorPage enterNumberOfNodes(String number) {
        WebElement input = new WebDriverWait(driver, 5).until(ExpectedConditions.
                presenceOfElementLocated(NUMBER_OF_NODES_INPUT));
        input.sendKeys(String.valueOf(number));
        return this;
    }

    public CalculatorPage addGPUs(String numberOfGPUs) {
        scrollAndClickOnElement(ADD_GPU_CHECK_BOX);
        waitForElementIsClickableAndClickOnIt(ADD_GPU_BOX);
        waitForElementIsClickableAndClickOnIt(By
                .xpath("//md-option[@value='" + numberOfGPUs + "'][@ng-value='item.value']"));
        return this;
    }

    public CalculatorPage selectGPUsType(String typeOfGPU) {
        scrollAndClickOnElement(SELECT_GPU_TYPE_BOX);
        waitForElementIsClickableAndClickOnIt(By.xpath("//div[contains(text(), '" + typeOfGPU + "')]/.."));
        return this;
    }

    public CalculatorPage addLocalSSD() {
        scrollAndClickOnElement(ADD_LOCAL_SSD_BOX);
        waitForElementIsClickableAndClickOnIt(By.xpath("//div[contains(text(), '24x375')]/.."));
        return this;
    }

    public CalculatorPage selectDatacenterLocation(String location) {
        scrollAndClickOnElement(DATACENTER_LOCATION_BOX);
        waitForElementIsClickableAndClickOnIt(By.xpath("(//md-option/div[contains(text(), '" + location + "')])[3]"));
        return this;
    }

    public CalculatorPage selectCommittedUsage(String usageYears) {
        scrollAndClickOnElement(COMMITTED_USAGE_BOX);
        waitForElementIsClickableAndClickOnIt(By
                .xpath("//div[@aria-hidden='false']//md-option[@value='" + usageYears + "']"));
        return this;
    }

    public CalculatorPage addInstanceToEstimate() {
        scrollAndClickOnElement(ADD_INSTANCE_TO_ESTIMATE_BUTTON);
        return this;
    }

    public CalculatorPage addNodeToEstimate() {
        scrollAndClickOnElement(ADD_NODE_TO_ESTIMATE_BUTTON);
        return this;
    }

    public String getTotalEstimatedCost() {
        return driver.findElement(By.xpath("//b[contains(text(), 'Total Estimated Cost')]")).getText();
    }

    public CalculatorPage initEmailEstimate() {
        scrollAndClickOnElement(INIT_EMAIL_ESTIMATE_BUTTON);
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
        scrollAndClickOnElement(SEND_MESSAGE_TO_EMAIL_BUTTON);
        return this;
    }
}
