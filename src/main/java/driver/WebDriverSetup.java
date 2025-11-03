package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@Getter
public class WebDriverSetup {

    protected WebDriver driver;
    private static WebDriverSetup instance;

    public WebDriver setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static WebDriverSetup getInstance() {
        if (instance == null) {
            instance = new WebDriverSetup();
        }
        return instance;
    }
}
