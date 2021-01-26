package com.letskodeit.testcases;

import com.letskodeit.base.BaseTest;
import com.letskodeit.pageObjects.VerifySearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchSalesTest extends BaseTest {

    @BeforeClass
    public void setUp(){
        login.loginWith("admin@yourstore.com", "admin");
    }
    @Test
    public void testSearchSales(){
        nav.saleOrdersSearch();
        search.searchOrders("2");
        VerifySearchResultPage searchResult = new VerifySearchResultPage(driver);
        boolean result = searchResult.verifyOrders();
        Assert.assertTrue(result);
    }
    @AfterClass
    public void tearDown(){
        login.clickLogout();
        driver.close();
    }
}
