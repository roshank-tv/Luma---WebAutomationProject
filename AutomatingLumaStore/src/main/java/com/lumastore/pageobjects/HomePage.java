package com.lumastore.pageobjects;

import com.lumastore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BaseClass {

    @FindBy(id = "search")
    WebElement searchBox;

    @FindBy(xpath = "//button[@class='action search']")
    WebElement searchButton;

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")
    WebElement dropDownButton;

    @FindBy(partialLinkText = "My Account")
    WebElement myAccountButton;

    @FindBy(xpath = "//span[contains(text(),'Men')]")
    WebElement menSectionDropdown;

    @FindBy(xpath = "//a[contains(text(),'Jackets')]")
    WebElement jacketButton;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public SearchResultPage navigateToSearchResultPage(String productName) {
        searchBox.sendKeys(productName);
        searchButton.click();
        return new SearchResultPage();
    }

    public UserAccountPage navigateToUserAccountPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(dropDownButton));
        dropDownButton.click();
        wait.until(ExpectedConditions.visibilityOf(myAccountButton));
        myAccountButton.click();
        return new UserAccountPage();
    }

    public FilterPage navigateToFilterPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(menSectionDropdown));
        menSectionDropdown.click();
        wait.until(ExpectedConditions.visibilityOf(jacketButton));
        jacketButton.click();
        return new FilterPage();
    }

}
