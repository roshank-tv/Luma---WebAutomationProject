package com.lumastore.testcases;

import com.lumastore.base.BaseClass;
import com.lumastore.pageobjects.HomePage;
import com.lumastore.pageobjects.IndexPage;
import com.lumastore.pageobjects.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Signature;

public class TestHomePage extends BaseClass {

    IndexPage indexPage;
    SignInPage signInPage;
    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        launchDriver();
    }

    @AfterMethod
    public void tearDown() {
        abortDriver();
    }

    @Test(groups = {"runAll","smoke"})
    public void testNavigateToSearchResultPage() {
        indexPage = new IndexPage();
        signInPage = indexPage.navigateToSignInPage();
        homePage = signInPage.navigateToHomePage("roshank@testvagrant.com", "123@Password");
        homePage.navigateToSearchResultPage("shirt");
        Assert.assertEquals(driver.getTitle(), "Search results for: 'shirt'", "Title Not Matching!!");
    }
}
