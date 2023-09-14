package com.lumastore.pageobjects;

import com.lumastore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FilterPage extends BaseClass {

    @FindBy(xpath = "//div[contains(text(),'Color')]")
    WebElement colorFilter;

    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[4]/div[2]/div/div/a[1]/div")
    WebElement blackColor;

    @FindBy(xpath = "//span[contains(text(),'Black')]")
    WebElement filterMessage;

    public FilterPage() {
        PageFactory.initElements(driver, this);
    }

    public String selectingBlackColorFilter() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(colorFilter));
        colorFilter.click();
        wait.until(ExpectedConditions.visibilityOf(blackColor));
        blackColor.click();
        return filterMessage.getText();
    }
}
