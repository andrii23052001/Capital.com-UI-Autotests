package pageObjects;

import basePage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(xpath = "(//div[@data-sentry-component='SwitcherLangCountry'])[1]")
    private WebElement switchCountryIcon;

    public MainPage() {
    }
    public RegionalSettingsPage clickOnTheSwitchCountryIcon() {
        clickOfElementWithWaiter(switchCountryIcon);
        return new RegionalSettingsPage();
    }
}