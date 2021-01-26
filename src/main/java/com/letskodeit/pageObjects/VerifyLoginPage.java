package com.letskodeit.pageObjects;

import com.letskodeit.base.BasePage;
import com.letskodeit.utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyLoginPage extends BasePage {
    public WebDriver driver;
    public VerifyLoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    private String ACCOUNT_USER_XPATH = "/html/body/div[3]/div[1]/div/div/ul/li[2]";

    public boolean verifyUser(){
        WebElement accUser= driver.findElement(By.xpath(ACCOUNT_USER_XPATH));
        boolean result = true;
        if (accUser.getText().contains("John")){
            System.out.println(accUser.getText());
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }
    public boolean isUserLoggedIn(String expectedTitle){
        String actTitle = driver.getTitle();
        return Util.verifyTextContains(actTitle, expectedTitle);
    }
}
