package baseTest;

import driver.WebDriverSetup;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.MainPage;
import pageObjects.RegionalSettingsPage;

import java.time.Duration;

public class BaseTest extends WebDriverSetup {
    protected MainPage mainPage;
    protected RegionalSettingsPage regionalSettingsPage;
    protected WebDriverWait wait;

    @BeforeTest
    public void before() {
        driver = WebDriverSetup.getInstance().setupDriver();
        mainPage = new MainPage();
        regionalSettingsPage = new RegionalSettingsPage();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterTest
    public void after() {
        driver.quit();
    }
}
