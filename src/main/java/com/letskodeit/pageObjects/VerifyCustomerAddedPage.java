package com.letskodeit.pageObjects;

import com.letskodeit.base.BasePage;
import com.letskodeit.utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyCustomerAddedPage extends BasePage {
    WebDriver driver;
    private String ALERT_MESSAGE_XPATH = "/html/body/div[3]/div[3]/div[1]";

    public VerifyCustomerAddedPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public boolean isCustomerAdded(){
        WebElement alerMessage = driver.findElement(By.xpath(ALERT_MESSAGE_XPATH));
        String actualMsg = alerMessage.getText();
        String expectedMsg = "has been added successfully";
        return Util.verifyTextContains(actualMsg, expectedMsg);
    }
}
