package bringiton.test;

import bringiton.page.CreatedPastePage;
import bringiton.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PastebinTests {
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private static final String PASTE_NAME = "how to gain dominance among developers";
    private static final String PASTE_CODE =
                    "git config --global user.name  \"New Sheriff in Town\"\n" +
                    "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                    "git push origin master --force";
    private static final String PASTE_SYNTAX = "Bash";
    private WebDriver driver;
    private CreatedPastePage createdPastePage;

    @BeforeTest(alwaysRun = true)
    public void initBrowserAndCreateANewPaste() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        createdPastePage = createANewPaste();
    }

    @Test
    public void testIsPasteNameEqualToExpected() {
        String currentPasteName = createdPastePage.getPasteName();
        Assert.assertEquals(currentPasteName, PASTE_NAME);
    }

    @Test
    public void testIsPasteSyntaxEqualToExpected() {
        String currentPasteSyntax = createdPastePage.getPasteSyntax();
        Assert.assertEquals(currentPasteSyntax, PASTE_SYNTAX);
    }

    @Test
    public void testIsPasteCodeEqualToExpected() {
        String currentPasteCode = createdPastePage.getPasteCode();
        Assert.assertEquals(currentPasteCode, PASTE_CODE);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    private CreatedPastePage createANewPaste() {
        return new HomePage(driver)
                .openPage(HOMEPAGE_URL)
                .enterPasteName(PASTE_NAME)
                .enterPasteCode(PASTE_CODE)
                .setPasteExpirationOnTenMinutes()
                .setPasteSyntax(PASTE_SYNTAX)
                .createPaste();
    }
}
