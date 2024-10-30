package com.demoqa.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextBox {

    private WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Нурсултан Байке\\DemoQaWinter24\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        // Используйте явное ожидание вместо Thread.sleep
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userName")));
    }

    @Test
    public void testTextBoxFullName() throws InterruptedException {
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Балдуин IV Иерусалимский");
    }

    @Test
    public void testTextBoxEmail() throws InterruptedException {
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("onegirisan3@gmail.com");
    }

    @Test
    public void testTextBoxCurrentAddress() throws InterruptedException {
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Mars");
    }

    @Test
    public void testTextBoxPermanentAddress() throws InterruptedException {
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Earth");
    }

    @Test
    public void testTextBoxSubmit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(18));
        WebElement submit = driver.findElement(By.id("submit"));

        // Прокрутите до элемента
        Actions actions = new Actions(driver);
        actions.moveToElement(submit).perform();

        // Убедитесь, что элемент видим
        wait.until(ExpectedConditions.visibilityOf(submit));

        // Кликните по элементу
        submit.click();

        // Пример проверки: убедитесь, что после нажатия кнопки на странице появляется элемент с ID 'output'
        WebElement resultElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("output")));
        Assert.assertTrue(resultElement.isDisplayed(), "Результирующий элемент не отображается");
    }

    @AfterClass
    public void tearDown() {
        driver.close(); // закрыть текущее окно браузера
        driver.quit();  // завершить сеанс WebDriver
    }
}

