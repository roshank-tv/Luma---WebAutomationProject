package com.lumastore.testcases;

import com.lumastore.base.BaseClass;
import com.lumastore.pageobjects.FilterPage;
import com.lumastore.pageobjects.HomePage;
import com.lumastore.pageobjects.IndexPage;
import com.lumastore.pageobjects.SignInPage;
import org.testng.Assert;
import org.testng.FileAssert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestFilterPage extends BaseClass {
    IndexPage indexPage;
    SignInPage signInPage;
    HomePage homePage;
    FilterPage filterPage;

    @BeforeMethod
    public void setUp() {
        launchDriver();
        indexPage = new IndexPage();
        signInPage = indexPage.navigateToSignInPage();
        homePage = signInPage.navigateToHomePage("roshank@testvagrant.com", "123@Password");
        filterPage = homePage.navigateToFilterPage();
    }

    @AfterMethod
    public void tearDown() {
        abortDriver();
    }

    @Test(groups = {"runAll","sanity"})
    public void testingNavigateToFilterPage() {
        Assert.assertEquals(driver.getTitle(), "Jackets - Tops - Men", "Title Not Matching!!");
    }

    @Test(groups = {"runAll","sanity"})
    public void testingProductFiltering() {
        String msg;
        msg = filterPage.selectingBlackColorFilter();
        Assert.assertEquals(msg, "Black", "Filtering fail!!");
    }
}
