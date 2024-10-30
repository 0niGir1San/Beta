package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.helper.DropDownHelper;
import com.demoqa.helper.WebElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;
    protected WebElementActions webElementActions;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.webElementActions = new WebElementActions(driver);
        PageFactory.initElements(driver, this);
    }

public DropDownHelper dropDownHelper = new DropDownHelper(DriverManager.getDriver());
}

