package sen.gmail.email;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class My1Test {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://yandex.ru");
    }

    @Test
    public void FindWeather() {
        WebElement SearchField = driver.findElement(By.id("text"));
        SearchField.sendKeys("погода пенза");
        WebElement SearchButton = driver.findElement(By.cssSelector("button[type='submit']"));
        SearchButton.click();
        WebElement WeatherField = driver.findElement(By.cssSelector("a[accesskey='2']"));
        Assert.assertTrue(WeatherField.getText().contains("Пенз"));
        driver.quit();
        //String WeatherSity = WeatherField.getText();

        // WeatherField.click();
        // findElement(By.partialLinkText("Пензе"));
          }
}