package com.lumastore.testcases;

import com.lumastore.base.BaseClass;
import com.lumastore.pageobjects.IndexPage;
import com.lumastore.pageobjects.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSignInPage extends BaseClass {

    IndexPage indexPage;
    SignInPage signInPage;

    @BeforeMethod
    public void setUp() {
        launchDriver();
    }

    @AfterMethod
    public void tearDown() {
        abortDriver();
    }

    @Test(groups = {"runAll","smoke"})
    public void testingNavigateToHomePage () {
        indexPage = new IndexPage();
        signInPage = indexPage.navigateToSignInPage();
        signInPage.navigateToHomePage("roshank@testvagrant.com", "123@Password");
        Assert.assertEquals(driver.getTitle(), "Home Page", "Title not Matching");
    }
