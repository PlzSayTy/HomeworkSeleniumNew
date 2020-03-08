import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FirstScenarioTest {
    WebDriver driver;
    String baseUrl;
    @Before
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.rgs.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void mainTest(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        driver.get(baseUrl);
        driver.findElement(By.xpath("//ol[contains(@class, 'nav navbar-nav navbar-nav-rgs-menu pull-left')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'���')]")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement((By.xpath("//h1[contains(text(), '���')]")))));
        Assert.assertEquals("��� � ������������ ����������� �����������", driver.findElement((By.xpath("//h1[contains(text(), '���')]"))).getText());
        driver.findElement(By.xpath("//*[contains(@class, 'btn btn-default text-uppercase hidden-xs adv-analytics-navigation-desktop-floating-menu-button')]")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//b[contains(text(), '������ �� ������������ ����������� �����������')]"))));
        Assert.assertEquals("������ �� ������������ ����������� �����������", driver.findElement((By.xpath("//b[contains(text(), '������ �� ������������ ����������� �����������')]"))).getText());
        driver.findElement(By.xpath("//input[contains(@name, 'LastName')]")).sendKeys("���������");
        driver.findElement(By.xpath("//input[contains(@name, 'FirstName')]")).sendKeys("��������");
        driver.findElement(By.xpath("//input[contains(@name, 'MiddleName')]")).sendKeys("���������");
        driver.findElement(By.xpath("//select[contains(@name, 'Region')]")).click();
        driver.findElement(By.xpath("//option[contains(text(), '������')]")).click();
        driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[2]/div[2]/form/div[2]/div[5]/input")).click();
        driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[2]/div[2]/form/div[2]/div[5]/input")).sendKeys("9168378267");
        driver.findElement(By.xpath("//input[contains(@name, 'Email')]")).sendKeys("qwertyqwerty");
        driver.findElement(By.xpath("//input[contains(@name, 'ContactDate')]")).click();
        driver.findElement(By.xpath("//input[contains(@name, 'ContactDate')]")).sendKeys("10.03.2020");
        driver.findElement(By.xpath("//textarea[contains(@name, 'Comment')]")).click();
        driver.findElement(By.xpath("//textarea[contains(@name, 'Comment')]")).sendKeys("�������� �����������");
        driver.findElement(By.xpath("//input[contains(@class, 'checkbox')]")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(), '������� ����� ����������� �����')]"))));
        System.out.println(driver.findElement(By.xpath("//input[contains(@name, 'LastName')]")).getAttribute("value"));
        Assert.assertEquals("���������", driver.findElement(By.xpath("//input[contains(@name, 'LastName')]")).getAttribute("value"));
        Assert.assertEquals("��������", driver.findElement(By.xpath("//input[contains(@name, 'FirstName')]")).getAttribute("value"));
        Assert.assertEquals("���������", driver.findElement(By.xpath("//input[contains(@name, 'MiddleName')]")).getAttribute("value"));
        Assert.assertEquals("77", driver.findElement(By.xpath("//select[contains(@name, 'Region')]")).getAttribute("value"));
        Assert.assertEquals("qwertyqwerty", driver.findElement(By.xpath("//input[contains(@name, 'Email')]")).getAttribute("value"));
        Assert.assertEquals("+7 (916) 837-82-67", driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[2]/div[2]/form/div[2]/div[5]/input")).getAttribute("value"));
        Assert.assertEquals("10.03.2020", driver.findElement(By.xpath("//input[contains(@name, 'ContactDate')]")).getAttribute("value"));
        Assert.assertEquals("�������� �����������", driver.findElement(By.xpath("//textarea[contains(@name, 'Comment')]")).getAttribute("value"));
        driver.findElement(By.xpath("//button[contains(@id, 'button-m')]")).click();
        Assert.assertEquals("������� ����� ����������� �����", driver.findElement(By.xpath("//span[contains(text(), '������� ����� ����������� �����')]")).getText());
    }
    @After
    public void closeTest(){
        driver.close();
    }
}
