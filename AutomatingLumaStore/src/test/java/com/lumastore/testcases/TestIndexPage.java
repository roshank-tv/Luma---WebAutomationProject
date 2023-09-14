package com.lumastore.testcases;

import com.lumastore.base.BaseClass;
import com.lumastore.pageobjects.IndexPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestIndexPage extends BaseClass {

    IndexPage indexPage;

    @BeforeMethod
    public void setUp() {
        launchDriver();
    }

    @AfterMethod
    public void tearDown() {
        abortDriver();
    }

    @Test
    public void testNavigateToSignInPage() {
        indexPage = new IndexPage();
        indexPage.navigateToSignInPage();
        Assert.assertEquals(driver.getTitle(), "Customer Login", "Title not matching!!");
    }
}
