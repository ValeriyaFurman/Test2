package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    WebDriver driver;

    By buttonNews = By.xpath("//header/ul/li[4]/a");

    public MainPage(WebDriver driver) {

        this.driver = driver;
    }

    public NewsPage navigateNews() {

        driver.findElement(buttonNews).click();
        return new NewsPage(driver);
    }
}