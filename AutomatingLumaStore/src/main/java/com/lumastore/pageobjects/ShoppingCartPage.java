package com.lumastore.pageobjects;

import com.lumastore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BaseClass {

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/ul/li[1]/button")
    WebElement proceedToCheckoutButton;

    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    public AddressPage navigateToAddressPage() {
        proceedToCheckoutButton.click();
        return new AddressPage();
    }
}
