package com.letskodeit.pageObjects;

import com.letskodeit.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage extends BasePage {
    public WebDriver driver;
    public NavigationPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    private String SALES_MENU_XPATH = "xpath=>/html/body/div[3]/div[2]/div/ul/li[3]/a";
    private String ORDER_MENU_ITEM_XPATH = "xpath=>/html/body/div[3]/div[2]/div/ul/li[3]/ul/li[1]/a";

    private String CUSTOMERS_MENU_XPATH = "xpath=>/html/body/div[3]/div[2]/div/ul/li[4]/a";
    private String CUSTOMERS_MENU_ITEM_XPATH = "xpath=>/html/body/div[3]/div[2]/div/ul/li[4]/ul/li[1]/a";

    public void saleOrdersSearch(){
        elementClick(SALES_MENU_XPATH,"Sales Menu");
        elementClick(ORDER_MENU_ITEM_XPATH, "Order Menu Item");
    }
    public void navigateCustomers(){
        elementClick(CUSTOMERS_MENU_XPATH,"Customers Menu");
        elementClick(CUSTOMERS_MENU_ITEM_XPATH, "Customers Menu Item");
    }
}
