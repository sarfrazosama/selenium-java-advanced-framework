package com.letskodeit.pageObjects;

import com.letskodeit.base.BasePage;
import com.letskodeit.utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage extends BasePage {
    WebDriver driver;
    public AddCustomerPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    private String BTN_ADD_NEW_XPATH = "xpath=>/html/body/div[3]/div[3]/div/form[1]/div[1]/div/a";
    private String TXT_EMAIL_ID = "id=>Email";
    private String TXT_PASSWORD_ID = "id=>Password";
    private String TXT_FIRST_NAME_ID = "id=>FirstName";
    private String TXT_LAST_NAME_ID = "id=>LastName";
    private String RD_GENDER_MALE_ID = "id=>Gender_Male";
    private String RD_GENDER_FEMALE_ID = "id=>Gender_Female";
    private String TXT_COMPANY_ID = "id=>Company";
    private String DRP_VENDOR_ID = "VendorId";
    private String BTN_SAVE_NAME = "name=>save";

    public boolean verifyCustomerPage(){
        String actTitle = driver.getTitle();
        String expectedTitle = "Customers / nopCommerce administration";
        return Util.verifyTextMatch(actTitle, expectedTitle);
    }

    public void setCredentials(String email, String password){
        elementClick(BTN_ADD_NEW_XPATH,"Add New Button");
        sendData(TXT_EMAIL_ID, email, "Customer Email", true);
        sendData(TXT_PASSWORD_ID, password, "Customer Password", true);
    }
    public void setName(String fname, String lname){
        sendData(TXT_FIRST_NAME_ID,fname,"First Name", true);
        sendData(TXT_LAST_NAME_ID,lname, "Last Name",true);
    }
    public void selectGender(String gender){
        if (gender=="M"){
            elementClick(RD_GENDER_MALE_ID,"Male");
        }
        else if(gender=="F"){
            elementClick(RD_GENDER_FEMALE_ID,"Female");
        }
        else{
            elementClick(RD_GENDER_MALE_ID,"Male");
        }
    }
    public void setCompany(String company){
        sendData(TXT_COMPANY_ID, company, "Company Name", true);
    }
    public void selectVendor(String value){
        WebElement drp = driver.findElement(By.id(DRP_VENDOR_ID));
        Select select = new Select(drp);
        select.selectByValue(value);
    }
    public void clickSave(){
        elementClick(BTN_SAVE_NAME, "Save Button");
    }
}
