package resourses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Utils {

    public static WebDriver driver = null;
    static String chromeBrowser = "Chrome";
    static String firefoxBrowser = "FireFox";
    static String baseUrl = "https://dou.ua/";

    public static WebDriver getDriver(String browser) {

        if (browser.equalsIgnoreCase(firefoxBrowser)) {
            System.setProperty("webdriver.gecko.driver", "//Users//valeriya//Desktop//GeckoDriver//geckoDriver");
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase(chromeBrowser)) {
            System.setProperty("webdriver.chrome.driver", "//Users//valeriya//Desktop//ChromeDriver//chromedriver");
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(baseUrl);

    return driver;
    }
}