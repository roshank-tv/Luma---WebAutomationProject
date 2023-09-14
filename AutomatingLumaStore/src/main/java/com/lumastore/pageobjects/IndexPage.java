package com.lumastore.pageobjects;

import com.lumastore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BaseClass {

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a")
    WebElement signInButton;

    public IndexPage() {
        PageFactory.initElements(driver, this);
    }

    public SignInPage navigateToSignInPage() {
        signInButton.click();
        return new SignInPage();
    }
}
