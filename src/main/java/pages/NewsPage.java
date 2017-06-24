package pages;

import com.beust.jcommander.internal.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class NewsPage {
    WebDriver driver;

    By firstLink = By.xpath("//article[1]/h2/a");
    By eventDate = By.xpath("//article[*]/div[1]/time");
    By eventTitle = By.xpath("//article[*]/h2/a");

    private static List dateToCompare = Lists.newArrayList("22 июня, 13:09",
            "22 июня, 10:00",
            "21 июня, 13:00",
            "21 июня, 10:00",
            "20 июня, 13:00",
            "20 июня, 10:06",
            "19 июня, 13:02",
            "19 июня, 10:00",
            "16 июня, 13:00",
            "16 июня, 10:00",
            "15 июня, 13:00",
            "15 июня, 10:00",
            "14 июня, 13:09",
            "14 июня, 10:00",
            "13 июня, 13:00",
            "13 июня, 10:00",
            "12 июня, 13:00",
            "12 июня, 10:00",
            "10 июня, 13:00",
            "10 июня, 10:00");


    public NewsPage(WebDriver driver) {

        this.driver = driver;
    }

    public void navigateToNews() {
        MainPage mainPage = new MainPage(driver);
        mainPage.navigateNews();
    }

    public NewsPage clickFirstLink() {

        driver.findElement(firstLink).click();
        return new NewsPage(driver);
    }

    public List<WebElement> getEventDateList() {
        List<WebElement> eventDateList = driver.findElements(eventDate);
        return eventDateList;
    }

    public void getEventTitleList() {
        List<WebElement> eventTitleList = driver.findElements(eventTitle);

        for (WebElement item : eventTitleList)
            System.out.println(item.getText());
    }

    public boolean compareEventDate() {
        boolean result = true;

        List<WebElement> eventDateList = getEventDateList();
        getEventDateList();
        for (int i = 0; i < eventDateList.size(); i++) {
        String eventDate = eventDateList.get(i).getText();
            if (!dateToCompare.get(i).equals(eventDate)) {
                System.out.println(eventDate);
                result = false;
            }
        }
            return result;
    }
}

