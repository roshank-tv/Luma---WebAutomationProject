package com.lumastore.testcases;

import com.lumastore.base.BaseClass;
import com.lumastore.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestShoppingCartPage extends BaseClass {

    IndexPage indexPage;
    SignInPage signInPage;
    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod
    public void setUp() {
        launchDriver();
    }

    @AfterMethod
    public void tearDown() {
        abortDriver();
    }

    @Test(groups = {"runAll","sanity"})
    public void testNavigateToAddressPage() {
        indexPage = new IndexPage();
        signInPage = indexPage.navigateToSignInPage();
        homePage = signInPage.navigateToHomePage("roshank@testvagrant.com", "123@Password");
        searchResultPage = homePage.navigateToSearchResultPage("shirt");
        productPage = searchResultPage.navigateToProductPage();
        productPage.fillProductDetails();
        shoppingCartPage = productPage.navigateToShoppingCartPage();
        shoppingCartPage.navigateToAddressPage();
        Assert.assertEquals(driver.getTitle(), "Checkout", "Title not matching!!");
    }
}
