package com.lumastore.testcases;

import com.lumastore.base.BaseClass;
import com.lumastore.pageobjects.HomePage;
import com.lumastore.pageobjects.IndexPage;
import com.lumastore.pageobjects.SearchResultPage;
import com.lumastore.pageobjects.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSearchResultPage extends BaseClass {

    IndexPage indexPage;
    SignInPage signInPage;
    HomePage homePage;
    SearchResultPage searchResultPage;

    @BeforeMethod
    public void setUp() {
        launchDriver();
    }

    @AfterMethod
    public void tearDown() {
        abortDriver();
    }

    @Test(groups = {"runAll","smoke"})
    public void testNavigateToProductPage() {
        indexPage = new IndexPage();
        signInPage = indexPage.navigateToSignInPage();
        homePage = signInPage.navigateToHomePage("roshank@testvagrant.com", "123@Password");
        searchResultPage = homePage.navigateToSearchResultPage("shirt");
        searchResultPage.navigateToProductPage();
        Assert.assertEquals(driver.getTitle(), "Balboa Persistence Tee", "Title not matching!!");
    }
}
