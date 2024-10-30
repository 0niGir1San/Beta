package com.demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgressBarPage extends BasePage{

    @FindBy(id = "startStopButton")
    public WebElement startStopButton;

    @FindBy(id = "progressBar")
    public WebElement progressBar;

    @FindBy(xpath = "//div[@aria-valuenow]")
    public WebElement aria_valuenow;
}
