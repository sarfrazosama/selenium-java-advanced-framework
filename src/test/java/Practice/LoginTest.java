package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void before(){
        driver = new ChromeDriver();
        driver.get("https://admin-demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void testlogin() throws InterruptedException {
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys("admin");

        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
        Thread.sleep(2000);
        String expctdTitle = "Dashboard / nopCommerce administration";
        String actTitle = driver.getTitle();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Logout")).click();
        Assert.assertTrue(actTitle==expctdTitle, "The title does not match");
        }
    @Test(priority = 2)
    public void testInvalidlogin() throws InterruptedException {
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys("admin123@yourstore.com");
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys("admin");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
        Thread.sleep(2000);
        String expctdTitle = "Dashboard / nopCommerce administration";
        String actTitle = driver.getTitle();
        Assert.assertTrue(actTitle!=expctdTitle, "The title should not match if user not logged in");
    }
}
