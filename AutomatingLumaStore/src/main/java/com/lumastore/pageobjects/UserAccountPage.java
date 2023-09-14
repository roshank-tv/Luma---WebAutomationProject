package com.lumastore.pageobjects;

import com.lumastore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserAccountPage extends BaseClass {

    @FindBy(partialLinkText = "My Orders")
    WebElement myOrdersButton;

    @FindBy(partialLinkText = "My Wish List")
    WebElement myWishListButton;

    public UserAccountPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToMyOrdersPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(myOrdersButton));
        myOrdersButton.click();
    }

    public void navigateToMyWishListPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(myOrdersButton));
        myWishListButton.click();
    }
}
