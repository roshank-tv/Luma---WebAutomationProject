package com.lumastore.pageobjects;

import com.lumastore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BaseClass {

    @FindBy(id = "email")
    WebElement emailBox;

    @FindBy(id = "pass")
    WebElement passwordBox;

    @FindBy(id = "send2")
    WebElement signInButton;

    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    public HomePage navigateToHomePage(String emailId, String password) {
        emailBox.sendKeys(emailId);
        passwordBox.sendKeys(password);
        signInButton.click();
        return new HomePage();
    }
}
