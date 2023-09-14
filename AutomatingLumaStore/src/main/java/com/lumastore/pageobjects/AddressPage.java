package com.lumastore.pageobjects;

import com.lumastore.base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends BaseClass {

    @FindBy(xpath = "//button[@class='button action continue primary']")
    WebElement nextButton;

    public AddressPage() {
        PageFactory.initElements(driver, this);
    }

    public PaymentPage navigateToPaymentPage() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollBy(0,500)");
        nextButton.click();
        return new PaymentPage();
    }
}
