package com.letskodeit.pageObjects;

import com.letskodeit.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VerifySearchResultPage extends BasePage {
    public WebDriver driver;
    public VerifySearchResultPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public int ordersCount(){
        List<WebElement> rows= driver.findElements(By.xpath("/html/body/div[3]/div[3]/div/form[1]/div[2]/div/div/div[2]/div/div/div[1]/div/div/div[2]/table/tbody/tr"));
        int numRows = rows.size();
        System.out.println(rows.size());
        return numRows;
    }
    public boolean verifyOrders(){
        boolean result = true;
        if (ordersCount()>0){
            return true;
        }
        return false;
    }
}
