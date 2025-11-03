package pageObjects;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegionalSettingsPage extends BasePage {
    @FindBy(xpath = "//div[@data-testid=\"country_switcher_lng\"]")
    private WebElement switchLanguageField;
    @FindBy(xpath = "//button[@data-type=\"nav_country_english\"]")
    private WebElement englishLocalButton;
    @FindBy(xpath = "//button[@data-testid='country_switcher_apply']")
    private WebElement applyButton;
    @FindBy(xpath = "//div[@data-testid=\"country_switcher_ctry\"]")
    private WebElement changeCountryField;
    @FindBy(xpath = "//button[text()=\"Stay on this site\"]")
    private WebElement stayOnSiteButton;

    public RegionalSettingsPage() {
    }

    public RegionalSettingsPage clickOnTheSwitchLanguageField() {
        clickOfElementWithWaiter(switchLanguageField);
        return this;
    }

    public RegionalSettingsPage chooseEnglishLocal() {
        clickOfElementWithWaiter(englishLocalButton);
        return this;
    }

    public RegionalSettingsPage clickOnTheApplyButton() {
        clickOfElementWithWaiter(applyButton);
        return this;
    }

    public RegionalSettingsPage clickOnTheChangeCountryField() {
        clickOfElementWithWaiter(changeCountryField);
        return this;
    }

    public RegionalSettingsPage searchCountry(String country) {
        sendKeysWithWaiter(getCountryButton(country), country);
        return this;
    }

    public RegionalSettingsPage chooseActualCountry(String country) {
        clickOfElementWithWaiter(getCountryButton(country));
        return this;
    }

    public RegionalSettingsPage clickOnTheStayOnSiteButton() {
        clickOfElementWithWaiter(stayOnSiteButton);
        return this;
    }


    public String getActualCountry() {
        visibilityOfElement(changeCountryField);
        return changeCountryField.getText();
    }

    public WebElement getCountryButton(String countryCode) {
        String xpath = String.format("//button[@data-type='nav_country_%s']", countryCode.toLowerCase());
        return driver.findElement(By.xpath(xpath));
    }
}