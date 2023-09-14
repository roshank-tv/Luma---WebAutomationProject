package com.lumastore.pageobjects;

import com.lumastore.base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BaseClass {

    @FindBy(partialLinkText = "Balboa Persistence T")
    WebElement productName;

    public SearchResultPage() {
        PageFactory.initElements(driver, this);
    }

    public ProductPage navigateToProductPage() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollBy(0,500)");
        productName.click();
        return new ProductPage();
    }
}
