package tests;


import baseTest.BaseTest;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class CountrySwitchTest extends BaseTest {


    @BeforeMethod
    public void openMainPage() {
        String baseUrl = ConfigReader.get("base.url");
        driver.get(baseUrl);
    }

    @Test
    @Description("This test verifies that the user can change the country on the site, and the selected country is applied correctly.")
    public void testChangeCountrySuccessfully() {
        mainPage.clickOnTheSwitchCountryIcon()
                .clickOnTheChangeCountryField()
                .searchCountry("Germany")
                .chooseActualCountry("germany")
                .clickOnTheApplyButton()
                .clickOnTheStayOnSiteButton();
        mainPage.clickOnTheSwitchCountryIcon();

        Assert.assertEquals(regionalSettingsPage.getActualCountry(), "Germany", "Country did not change correctly");
    }
}
