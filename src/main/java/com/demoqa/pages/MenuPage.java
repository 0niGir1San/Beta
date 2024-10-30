package com.demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage{

    @FindBy(xpath = "//a[text()='Main Item 2']")
    public WebElement mainItem2;

    @FindBy(xpath = "//a[text()='SUB SUB LIS »']")
    public WebElement subSubList;
}
