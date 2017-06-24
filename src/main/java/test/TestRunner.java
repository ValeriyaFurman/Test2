package test;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.MainPage;
import pages.NewsPage;
import resourses.Utils;

public class TestRunner extends Utils {

    private static WebDriver driver;
    private static String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public static void setUp() throws Exception {
       driver = Utils.getDriver("Chrome");
    }

    @Test
    public void testMainPage() {
        MainPage mainPage = new MainPage(driver);
        NewsPage newsPage = mainPage.navigateNews();
        Assert.assertEquals("Новые записи — Лента | DOU", driver.getTitle());
        System.out.println(driver.getTitle());
    }

    @Test
    public void testNewsPage() {
        NewsPage newsPage = new NewsPage(driver);
        newsPage.navigateToNews();
        newsPage.clickFirstLink();
        Assert.assertEquals("Работа проджект-менеджера: как наладить идеальный рабочий процесс | DOU", driver.getTitle());
        System.out.println(driver.getTitle());
    }

    @Test
    public void testEventsDate() {
        NewsPage newsPage = new NewsPage(driver);
        newsPage.navigateToNews();
        newsPage.getEventTitleList();
        Assert.assertTrue("No matches!", newsPage.compareEventDate());
        System.out.println(newsPage.compareEventDate());
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
