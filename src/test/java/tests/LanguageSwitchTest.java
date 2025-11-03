package tests;

import baseTest.BaseTest;
import jdk.jfr.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class LanguageSwitchTest extends BaseTest {

    @BeforeMethod
    public void openMainPage() {
        String baseUrl = ConfigReader.get("base.url");
        driver.get(baseUrl);
    }

    @Test
    @Description("Verify that the site language can be successfully switched to English")
    public void changeLocalizationToEnglishTest() {
        mainPage.clickOnTheSwitchCountryIcon()
                .clickOnTheSwitchLanguageField()
                .chooseEnglishLocal()
                .clickOnTheApplyButton();

        wait.until(ExpectedConditions.urlToBe("https://capital.com/en-int"));

        Assert.assertEquals(driver.getCurrentUrl(), "https://capital.com/en-int", "Language did not change to English");

    }
}