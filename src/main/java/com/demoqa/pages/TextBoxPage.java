package com.demoqa.pages;

import com.demoqa.entities.TextBoxEntity;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {

    @FindBy(id = "userName")
    public WebElement fullNameInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    public TextBoxPage fillUpTextBoxForm(String fullName, String email, String currentAddress, String permanentAddress){
        webElementActions.sendKeys(fullNameInput,fullName)
                .sendKeys(emailInput,email)
                .sendKeys(currentAddressInput,currentAddress)
                .sendKeys(permanentAddressInput,permanentAddress)
                .click(submitBtn);
        return this;
    }

    public TextBoxPage fillUpTextBoxForm(TextBoxEntity textBoxEntity){
        webElementActions.sendKeys(fullNameInput,textBoxEntity.getFullName())
                .sendKeys(emailInput, textBoxEntity.getEmail())
                .sendKeys(currentAddressInput,textBoxEntity.getPermanentAddress())
                .sendKeys(permanentAddressInput,textBoxEntity.getPermanentAddress())
                .click(submitBtn);
        return this;
    }
}
