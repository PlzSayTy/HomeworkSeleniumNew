import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        driver.findElement(By.xpath("//div[contains(@class, 'kit-grid-modal__window')]//div[contains(@class, 'kit-input')]//child::input[contains(@class, 'kit-input__control')]")).sendKeys("Нижегородская область");
        driver.findElement(By.xpath("//div[contains(@class, 'kit-grid-modal__window')]//div[contains(@class, 'kit-input')]//child::input[contains(@class, 'kit-input__control')]")).sendKeys("\n");
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@class, 'hd-ft-region')]")).getText().equals("Нижегородская область"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//ul" +
                "[contains(@class, 'footer__social')]")));
        System.out.println(driver.findElement(By.xpath("//ul" +
                "[contains(@class, 'footer__social')]")).getAttribute("value"));
        Assertions.assertAll("Иконка исчезла", (Executable) () ->{
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'footer')]//span[contains(@class, 'footer__social_logo footer__social_fb')]")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'footer')]//span[contains(@class, 'footer__social_logo footer__social_tw')]")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'footer')]//span[contains(@class, 'footer__social_logo footer__social_yt')]")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'footer')]//span[contains(@class, 'footer__social_logo footer__social_ins')]")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'footer')]//span[contains(@class, 'footer__social_logo footer__social_vk')]")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'footer')]//span[contains(@class, 'footer__social_logo footer__social_ok')]")).isDisplayed());
        });
    }
    @After
    public void afterTest(){
        driver.quit();
    }
}
