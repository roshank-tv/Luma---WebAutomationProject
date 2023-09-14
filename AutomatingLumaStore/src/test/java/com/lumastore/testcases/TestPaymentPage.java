package com.lumastore.testcases;

import com.lumastore.base.BaseClass;
import com.lumastore.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPaymentPage extends BaseClass {

    IndexPage indexPage;
    SignInPage signInPage;
    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
    AddressPage addressPage;
    PaymentPage paymentPage;

    @BeforeMethod
    public void setUp() {
        launchDriver();
    }

    @AfterMethod
    public void tearDown() {
        abortDriver();
    }

    @Test(groups = {"runAll","smoke"})
    public void testOrderPlaced() {
        indexPage = new IndexPage();
        signInPage = indexPage.navigateToSignInPage();
        homePage = signInPage.navigateToHomePage("roshank@testvagrant.com", "123@Password");
        searchResultPage = homePage.navigateToSearchResultPage("shirt");
        productPage = searchResultPage.navigateToProductPage();
        productPage.fillProductDetails();
        shoppingCartPage = productPage.navigateToShoppingCartPage();
        addressPage = shoppingCartPage.navigateToAddressPage();
        paymentPage = addressPage.navigateToPaymentPage();
        String msg = paymentPage.orderPlace();
        Assert.assertEquals(msg, "Thank you for your purchase!", "URL not matching!!");
    }
}
