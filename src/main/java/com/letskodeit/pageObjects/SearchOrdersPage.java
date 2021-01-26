package com.letskodeit.pageObjects;

import com.letskodeit.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchOrdersPage extends BasePage{
    public WebDriver driver;
    public SearchOrdersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    private String BILLINGCOUNTRY_ID = "BillingCountryId";
    private String SEARCH_BTN_ID = "id=>search-orders";

    public void searchOrders(String value){
        WebElement country = driver.findElement(By.id(BILLINGCOUNTRY_ID));
        Select select = new Select(country);
        select.selectByValue(value);
        elementClick(SEARCH_BTN_ID, "Search Button");
    }
}
