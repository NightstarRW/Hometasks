package test;

import driver.DriverSingleton;
import model.ComputeEngine;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.CalculatorPage;
import page.CloudHomePage;
import page.MailPage;
import service.ComputeEngineCreator;
import util.StringUtil;
import util.TestListener;

import java.util.ArrayList;
import java.util.List;

@Listeners({TestListener.class})
public class CalculatorMailTest {
    private final static String CLOUD_HOME_PAGE_URL = "https://cloud.google.com/";
    private final static String SEARCH_TERM = "Google Cloud Platform Pricing Calculator";
    private WebDriver driver;

    @BeforeClass
    private void initBrowser() {
        driver = DriverSingleton.getDriver();
    }

    @Test
    public void testIsSiteCostEqualToMailMessageCost() {
        CalculatorPage calculatorPage = searchForCalculator();
        fillCalculatingData(calculatorPage);
        double currentSiteCost = StringUtil.getDoubleValueFromString(calculatorPage.getTotalEstimatedCost());

        ((JavascriptExecutor) driver).executeScript("window.open()");
        List<String> browserTabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabList.get(1));
        MailPage mailPage = new MailPage(driver);
        mailPage.openMailPage().copyEmailAddress();

        driver.switchTo().window(browserTabList.get(0));
        calculatorPage.switchToCalculatorFrame()
                .initEmailEstimate().pasteEmailAddress().sendMessageToEmail();
        driver.switchTo().window(browserTabList.get(1));
        mailPage.waitForMessageAndOpenIt(120);
        double currentMailCost = StringUtil.getDoubleValueFromString(mailPage.getCostFromMessage());

        Assert.assertEquals(currentMailCost, currentSiteCost);
    }

    @AfterClass(alwaysRun = true)
    private void tearDown() {
        DriverSingleton.closeDriver();
        driver = null;
    }

    private CalculatorPage searchForCalculator() {
        return new CloudHomePage(driver)
                .openPage(CLOUD_HOME_PAGE_URL)
                .searchForTerm(SEARCH_TERM)
                .goToTheFirstSearchResult();
    }

    private void fillCalculatingData(CalculatorPage calculatorPage) {
        ComputeEngine computeEngine = ComputeEngineCreator.withDataFromProperty();
        calculatorPage
                .switchToCalculatorFrame()
                .enterNumberOfInstances(computeEngine.getNumberOfInstances())
                .selectMachineType(computeEngine.getMachineType())
                .enterNumberOfNodes(computeEngine.getNumberOfNodes())
                .addGPUs(computeEngine.getNumberOfGPUs())
                .selectGPUsType(computeEngine.getTypeOfGPUs())
                .addLocalSSD()
                .selectDatacenterLocation(computeEngine.getDatacenterLocation())
                .selectCommittedUsage(computeEngine.getCommittedUsage())
                .addInstanceToEstimate()
                .addNodeToEstimate();
    }
}
