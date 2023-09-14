package com.lumastore.pageobjects;

import com.lumastore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BaseClass {

    @FindBy(xpath = "//button[@class='action primary checkout']")
    WebElement placeOrderButton;

    @FindBy(xpath = "//span[@class='base']")
    WebElement successMessage;

    public PaymentPage() {
        PageFactory.initElements(driver, this);
    }

    public String orderPlace() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        placeOrderButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return successMessage.getText();
    }
}
