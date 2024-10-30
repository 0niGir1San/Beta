package com.demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectMenuPage extends BasePage{

    @FindBy(xpath = "//div[text()='Select Option']")
    public WebElement selectOne;

//    public SelectMenuPage fillUpSelectorMenuPage(){
//        webElementActions.randomElementSelection("//div[@class=' css-26l3qy-menu']/div/div/div[1]")
//    }
}
