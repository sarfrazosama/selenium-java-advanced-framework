package com.letskodeit.base;

import com.letskodeit.pageObjects.*;
import com.letskodeit.utilities.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    protected LoginPage login;
    protected NavigationPage nav;
    protected SearchOrdersPage search;
    protected AddCustomerPage addCustomer;
    protected VerifyCustomerAddedPage verifyCustomerAdded;
    protected String baseURL = Constants.BASE_URL;


    @BeforeClass
    public void commonSetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        login = new LoginPage(driver);
        nav = new NavigationPage(driver);
        search = new SearchOrdersPage(driver);
        addCustomer = new AddCustomerPage(driver);
        verifyCustomerAdded = new VerifyCustomerAddedPage(driver);
    }
    @BeforeMethod
    public void beforeMethod(){
        CheckPoint.clearHashMap();
    }

    @AfterClass
    public void commonTearDown(){
        driver.quit();
    }
}
