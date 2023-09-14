package com.lumastore.testcases;

import com.lumastore.base.BaseClass;
import com.lumastore.pageobjects.HomePage;
import com.lumastore.pageobjects.IndexPage;
import com.lumastore.pageobjects.SignInPage;
import com.lumastore.pageobjects.UserAccountPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestMyWishListPage extends BaseClass {
    IndexPage indexPage;
    SignInPage signInPage;
    HomePage homePage;
    UserAccountPage userAccountPage;

    @BeforeMethod
    public void setUp() {
        launchDriver();
    }

    @AfterMethod
    public void tearDown() {
        abortDriver();
    }

    @Test(groups = {"runAll","sanity"})
    public void testingNavigateToMyWishListPage() {
        indexPage = new IndexPage();
        signInPage = indexPage.navigateToSignInPage();
        homePage = signInPage.navigateToHomePage("roshank@testvagrant.com", "123@Password");
        userAccountPage = homePage.navigateToUserAccountPage();
        userAccountPage.navigateToMyWishListPage();
        Assert.assertEquals(driver.getTitle(), "My Wish List", "Title not matching!!");
    }
}
