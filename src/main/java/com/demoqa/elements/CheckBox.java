package com.demoqa.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBox {

    private static WebDriver driver;

    //4169 5853 5971 4820
    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Нурсултан Байке\\DemoQaWinter24\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
    }

    @Test
    public void testToggleFolder() {
        // Загрузите вашу HTML-страницу
        driver.get("file:///path/to/your/file.html");

        // Найдите переключатель (стрелку)
        WebElement toggleButton = driver.findElement(By.cssSelector("svg.rct-icon.rct-icon-expand-close"));

        // Кликните на переключатель (стрелку)
        toggleButton.click();

        // Проверьте, что произошло после клика, например, что появилась вложенная структура
        // Это зависит от вашей HTML-структуры и логики отображения
        // Пример: проверить, что элемент с id "home-checkbox" теперь виден
        WebElement homeCheckbox = driver.findElement(By.id("home-checkbox"));
        Assert.assertTrue(homeCheckbox.isDisplayed(), "Home checkbox should be displayed after toggling the folder");
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}