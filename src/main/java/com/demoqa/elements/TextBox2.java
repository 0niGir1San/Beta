package com.demoqa.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextBox2 {
    @Test
    void textBoxTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Нурсултан Байке\\DemoQaWinter24\\src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver(); //мостик интерфейс
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  //
        driver.manage().window().maximize(); //открой окно на весь экран
        driver.get("https://demoqa.com/text-box");  //открытие веб-страницы по указанному URL
        Thread.sleep(5000); // приостанавливает выполнение текущего потока на указанный промежуток времени в миллисекундах


        WebElement fullName = driver.findElement(By.id("userName")); //найти определенный элемент по ID
        fullName.sendKeys("Балдуин IV Иерусалимский");  //Введи в этот ID "Балдуин IV Иерусалимский"


        driver.close();  //закрыть браузер
        driver.quit();  //выйти с сессии
    }
}
