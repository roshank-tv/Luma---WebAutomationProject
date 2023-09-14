package com.lumastore.pageobjects;

import com.lumastore.base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BaseClass {

    @FindBy(id = "option-label-size-143-item-168")
    WebElement productSize;

    @FindBy(id = "option-label-color-93-item-52")
    WebElement productColor;

    @FindBy(id = "qty")
    WebElement productQuantity;

    @FindBy(id = "product-addtocart-button")
    WebElement addToCartButton;

    @FindBy(partialLinkText = "My Cart")
    WebElement myCartButton;

    @FindBy(partialLinkText = "View and Edit Cart")
    WebElement goToCartButton;

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    public void fillProductDetails() {
        productSize.click();
        productColor.click();

        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollBy(0,500)");
        productQuantity.clear();
        productQuantity.sendKeys("2");
        addToCartButton.click();
    }

    public ShoppingCartPage navigateToShoppingCartPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(myCartButton));
        myCartButton.click();
        wait.until(ExpectedConditions.visibilityOf(goToCartButton));
        goToCartButton.click();
        return new ShoppingCartPage();
    }


}
