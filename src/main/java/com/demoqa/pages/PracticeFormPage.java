package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.entities.PracticeFormEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class PracticeFormPage extends BasePage{

    public PracticeFormPage(){
        PageFactory.initElements(DriverManager.getDriver(), TextBoxPage.class);
    }

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(xpath = "//label[text()='Male']")
    public WebElement genderBtn;

    @FindBy(id = "userNumber")
    public WebElement userNumberInput;

    @FindBy(id = "subjectsInput")
    public WebElement subjectsInput;

    @FindBy(xpath = "//label[text()='Sports']")
    public WebElement hobbiesBtn;

    @FindBy (id = "uploadPicture")
    public  WebElement selectPicture;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;

    @FindBy(id = "react-select-3-input")
    public WebElement stateInput;

    @FindBy(id = "react-select-4-input")
    public WebElement cityInput;

    @FindBy(className = "dateOfBirthInput")
    public WebElement dateInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    public  PracticeFormPage selectRandomDate () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dateOfBirthInput"))); // Используйте правильный локатор

        dateInput.click();

        // Список всех годов
        WebElement yearDropDown = driver.findElement(By.className("react-datepicker__year-select"));
        Select yearSelect = new Select(yearDropDown);
        // Кладем все в список
        List<WebElement> years = yearSelect.getOptions();
        // Рандомно выбираем один год используя генерацию индекса
        WebElement randomYear = years.get(ThreadLocalRandom.current().nextInt(years.size()));
        yearSelect.selectByVisibleText(randomYear.getText());

        // Случайным образом выбрать месяц
        WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
        Select monthSelect = new Select(monthDropdown);
        List<WebElement> months = monthSelect.getOptions();
        WebElement randomMonth = months.get(ThreadLocalRandom.current().nextInt(months.size()));
        monthSelect.selectByVisibleText(randomMonth.getText());

        // Нахождение всех дней на календаре
        List<WebElement> days = driver.findElements(By.className("react-datepicker__day"));

        // Фильтрация дней, чтобы исключить дни, не относящиеся к текущему месяцу
        days = days.stream()
                .filter(day -> !day.getAttribute("class").contains("react-datepicker__day--outside-month"))
                .collect(Collectors.toList());

        // Выбор случайного дня из списка
        WebElement randomDay = days.get(ThreadLocalRandom.current().nextInt(days.size()));
        randomDay.click();
        return this;
    }


//        String[] dateMonthYearParts = dateMonthYear.split(" ");
//        String date = dateMonthYearParts[0];
//        String month = dateMonthYearParts[1];
//        String year = dateMonthYearParts[2];
//
//        webElementActions.click(datePickerBtn);
//
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
//
//        WebElement monthDropDown = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("react-datepicker__month-select")));
//        WebElement yearDropDown = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("react-datepicker__year-select")));
//
//        dropDownHelper.selectByVisibleText(monthDropDown,month)
//                .selectByVisibleText(yearDropDown,year);
//
//        WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")
//        ))


    public PracticeFormPage fillUpPracticeForm (PracticeFormEntity practiceFormEntity) {
        webElementActions.sendKeys(firstNameInput, practiceFormEntity.getFirstName())
                .sendKeys(lastNameInput, practiceFormEntity.getLastName())
                .sendKeys(emailInput, practiceFormEntity.getEmail())
                .jsClick(webElementActions.randomElementSelection("//input[@name ='gender']"))
                .sendKeys(userNumberInput, practiceFormEntity.getMobileNumber())
                .sendKeysWithEnter(subjectsInput, practiceFormEntity.getSubjects())
                .clickRandomElements("//input[@type='checkbox']");

        selectRandomDate();

        webElementActions.sendKeys(selectPicture, practiceFormEntity.getSelectPicture())
                .sendKeys(currentAddressInput, practiceFormEntity.getCurrentAddress())
                .sendKeysWithEnter(stateInput, webElementActions.randomElementSelection("(//div[@class=' css-1hwfws3'])[1]", "//div[contains(@class,'menu')]//div[contains(@class,'option')]"))
                .sendKeysWithEnter(cityInput, webElementActions.randomElementSelection("(//div[@class=' css-1hwfws3'])[2]", "//div[contains(@class,'menu')]//div[contains(@class,'option')]"))
                .click(submitBtn);
        return this;
    }


}
