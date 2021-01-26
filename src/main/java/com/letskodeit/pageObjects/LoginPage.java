package com.letskodeit.pageObjects;

import com.letskodeit.base.BasePage;
import com.letskodeit.utilities.Util;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private String EMAIL_ID = "id=>Email";
    private String PASSWORD_ID = "id=>Password";
    private String LOGIN_BTN_XPATH = "xpath=>/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/input";
    private String LOGOUT_LINK_TXT = "link=>Logout";

    public void loginWith(String email, String password) {
        sendData(EMAIL_ID, email, "User email",true);
        sendData(PASSWORD_ID, password, "User Password",true);
        elementClick(LOGIN_BTN_XPATH,"Login Button");
    }

    public void clickLogout() {
        elementClick(LOGOUT_LINK_TXT,"Logout Link");
    }

    public boolean verifyLogin() {
        String expectedTitle = "Dashboard / nopCommerce administration";
        return Util.verifyTextMatch(getTitle(),expectedTitle);
    }
}
