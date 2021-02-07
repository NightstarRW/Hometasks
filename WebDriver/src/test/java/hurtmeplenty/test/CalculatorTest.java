package hurtmeplenty.test;

import hurtmeplenty.page.CalculatorPage;
import hurtmeplenty.page.CloudHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorTest {
    private final static String HOME_PAGE_URL = "https://cloud.google.com/";
    private final static String SEARCH_TERM = "Google Cloud Platform Pricing Calculator";
    private static final String MACHINE_TYPE = "e2-standard-8";
    private static final String GPU_TYPE = "NVIDIA Tesla V100";
    private static final String DATACENTER_LOCATION = "Frankfurt";
    private static final String EXPECTED_COST = "Total Estimated Cost: USD 15,723.19 per 1 month";
    private WebDriver driver;

    @BeforeTest
    private void initBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testIsCurrentCostEqualToExpected() {
        CalculatorPage calculatorPage = searchForCalculator();
        fillCalculatingData(calculatorPage);
        Assert.assertEquals(calculatorPage.getTotalEstimatedCost(), EXPECTED_COST);
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
                .addNodeToEstimate()
                .getTotalEstimatedCost();
    }
}
