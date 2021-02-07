package hardcore.test;

import hardcore.page.CalculatorPage;
import hardcore.page.CloudHomePage;
import hardcore.page.MailPage;
import hardcore.util.StringUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CalculatorMailTest {
    private final static String HOME_PAGE_URL = "https://cloud.google.com/";
    private final static String SEARCH_TERM = "Google Cloud Platform Pricing Calculator";
    private static final String MACHINE_TYPE = "e2-standard-8";
    private static final String GPU_TYPE = "NVIDIA Tesla V100";
    private static final String DATACENTER_LOCATION = "Frankfurt";
    private WebDriver driver;

    @BeforeTest
    private void initBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testIsSiteCostEqualToMailMessageCost() {
        CalculatorPage calculatorPage = searchForCalculator();
        fillCalculatingData(calculatorPage);
        double currentSiteCost = StringUtil.getDoubleValueFromString(calculatorPage
                .getTotalEstimatedCost(), true);

        ((JavascriptExecutor) driver).executeScript("window.open()");
        List<String> browserTabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabList.get(1));
        MailPage mailPage = new MailPage(driver);
        mailPage.openMailPage().copyEmailAddress();

        driver.switchTo().window(browserTabList.get(0))
                .switchTo().frame(0)
                .switchTo().frame("myFrame");
        calculatorPage.initEmailEstimate().pasteEmailAddress().sendMessageToEmail();
        driver.switchTo().window(browserTabList.get(1));
        mailPage.waitForMessageAndOpenIt(120);
        double currentMailCost = StringUtil.getDoubleValueFromString(mailPage.getCostFromMessage(), false);

        Assert.assertEquals(currentMailCost, currentSiteCost);
    }

    @AfterTest(alwaysRun = true)
    private void tearDown() {
        driver.quit();
        driver = null;
    }

    private CalculatorPage searchForCalculator() {
        return new CloudHomePage(driver)
                .openPage(HOME_PAGE_URL)
                .searchForTerm(SEARCH_TERM)
                .goToTheFirstSearchResult();
    }

    private void fillCalculatingData(CalculatorPage calculatorPage) {
        calculatorPage
                .switchToCalculatorFrame()
                .enterNumberOfInstances(4)
                .selectMachineType(MACHINE_TYPE)
                .enterNumberOfNodes(4)
                .addGPUs(4)
                .selectGPUsType(GPU_TYPE)
                .addLocalSSD()
                .selectDatacenterLocation(DATACENTER_LOCATION)
                .selectCommittedUsage(1)
                .addInstanceToEstimate()
                .addNodeToEstimate();
    }
}
