package bringiton.test;

import bringiton.page.CreatedPastePage;
import bringiton.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

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

    @BeforeClass(alwaysRun = true)
    public void initBrowserAndCreateANewPaste() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        createdPastePage = createANewPaste();
    }

    @Test
    public void testIsPasteNameEqualToExpected() {
        Assert.assertEquals(createdPastePage.getPasteName(), PASTE_NAME);
    }

    @Test
    public void testIsPasteSyntaxEqualToExpected() {
        Assert.assertEquals(createdPastePage.getPasteSyntax(), PASTE_SYNTAX);
    }

    @Test
    public void testIsPasteCodeEqualToExpected() {
        Assert.assertEquals(createdPastePage.getPasteCode(), PASTE_CODE);
    }

    @AfterClass(alwaysRun = true)
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
