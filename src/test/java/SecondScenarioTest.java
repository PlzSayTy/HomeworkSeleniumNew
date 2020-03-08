import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SecondScenarioTest {
    WebDriver driver;
    String baseUrl;
    @Before
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void mainTest(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        driver.get(baseUrl);
        driver.findElement(By.xpath("//a[contains(@class, 'hd-ft-region')]")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Нижегородская область')]")).click();
        Assert.assertEquals("Нижегородская область", driver.findElement(By.xpath("//a[contains(@class, 'hd-ft-region')]")).getText());
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//footer")));
        Assert.assertTrue(driver.findElement(By.xpath("//ul[contains(@class, 'footer__social')]")).isDisplayed());
    }
    @After
    public void afterTest(){
        driver.quit();
    }
}
