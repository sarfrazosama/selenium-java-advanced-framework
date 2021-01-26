package com.letskodeit.testcases;

import com.letskodeit.base.BaseTest;
import com.letskodeit.base.CheckPoint;
import com.letskodeit.pageObjects.AddCustomerPage;
import com.letskodeit.pageObjects.VerifyCustomerAddedPage;
import com.letskodeit.utilities.Constants;
import com.letskodeit.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class AddCustomerTest extends BaseTest {

    @DataProvider(name = "AddCustomersData")
    public Object[][] getAddCustomerData(){
        Object[][] testData = ExcelUtility.getTestData("add_customer");
        return testData;
    }

    @BeforeClass
    public void setUp() {
        login.loginWith("admin@yourstore.com", "admin");
        File file = new File(Constants.EXCEL_FILE);
        ExcelUtility.setExcelFile(file, "AddCustomer");
    }
    @Test(dataProvider = "AddCustomersData")
    public void testAddCustomers(String email, String password, String fname, String lname, String gender, String company,String value){
        nav.navigateCustomers();
        boolean customerVerify = addCustomer.verifyCustomerPage();
        CheckPoint.mark("CustomerPage", customerVerify, "Customer Page Verification");
        addCustomer.setCredentials(email, password);
        addCustomer.setName(fname, lname);
        addCustomer.selectGender(gender);
        addCustomer.setCompany(company);
        addCustomer.selectVendor(value);
        addCustomer.clickSave();
        boolean check = verifyCustomerAdded.isCustomerAdded();
        CheckPoint.markFinal("CustomerAdded",check,"New Customer Verification");
    }
    @AfterClass
    public void tearDown(){
        login.clickLogout();
        driver.close();
    }
}
