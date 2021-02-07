package icanwin.test;

import icanwin.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreatingPasteTest {
    private static final String PASTEBIN_URL = "https://pastebin.com/";
    private static final String PASTE_NAME = "helloweb";
    private static final String PASTE_CODE = "Hello from WebDriver";
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testCreatingNewPaste() {
        new HomePage(driver)
                .openPage(PASTEBIN_URL)
                .enterPasteName(PASTE_NAME)
                .enterPasteCode(PASTE_CODE)
                .setPasteExpirationOnTenMinutes()
                .createPaste();
        System.out.println("\nResult Url: " + driver.getCurrentUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
