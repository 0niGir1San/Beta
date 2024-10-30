package com.demoqa.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Copy {
    @Test
    public void testCheckBox() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        webDriver.manage().window().maximize();
        webDriver.get("https://demoqa.com/checkbox");


        // Для того, чтобы вручную не прокручивать страницу вниз, чат GPT подсказал следующее решение:
        // Создание экземпляра JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        // Прокрутка страницы вниз на 1000 пикселей
        js.executeScript("window.scrollBy(0, 1000);");


        WebElement homeElement = webDriver.findElement(By.xpath("//*[@id='tree-node']/ol/li/span/button"));
        homeElement.click();

        WebElement desktopElement = webDriver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[1]/span/button"));
        desktopElement.click();

        WebElement notesElement = webDriver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[1]/ol/li[1]/span/label/span[1]"));
        notesElement.click();
        String actualMessageOfNotesElement = webDriver.findElement(By.xpath("//*[@id='result']")).getText();

        WebElement commandsElement = webDriver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[1]/ol/li[2]/span/label/span[1]"));
        commandsElement.click();
        String actualMessageOfCommandsElement = webDriver.findElement(By.xpath("//*[@id='result']")).getText();

        WebElement documentsElement = webDriver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[2]/span/button"));
        documentsElement.click();

        WebElement workSpaceElement = webDriver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[2]/ol/li[1]/span/button"));
        workSpaceElement.click();

        WebElement reactElement = webDriver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[2]/ol/li[1]/ol/li[1]/span/label/span[1]"));
        reactElement.click();
        String actualReactElement = webDriver.findElement(By.xpath("//*[@id='result']")).getText();

        WebElement angularElement = webDriver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[2]/ol/li[1]/ol/li[2]/span/label/span[1]"));
        angularElement.click();
        String actualAngularElement = webDriver.findElement(By.xpath("//*[@id='result']")).getText();

        WebElement veuElement = webDriver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[2]/ol/li[1]/ol/li[3]/span/label/span[1]"));
        veuElement.click();
        String actualVeuElement = webDriver.findElement(By.xpath("//*[@id='result']")).getText();

        WebElement officeElement = webDriver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[2]/ol/li[2]/span/button"));
        officeElement.click();

        WebElement publicElement = webDriver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[2]/ol/li[2]/ol/li[1]/span/label/span[1]"));
        publicElement.click();
        String actualPublicElement = webDriver.findElement(By.xpath("//*[@id='result']")).getText();

        WebElement privateElement = webDriver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[2]/ol/li[2]/ol/li[2]/span/label/span[1]"));
        privateElement.click();
        String actualPrivateElement = webDriver.findElement(By.xpath("//*[@id='result']")).getText();

        WebElement classifiedElement = webDriver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[2]/ol/li[2]/ol/li[3]/span/label/span[1]"));
        classifiedElement.click();
        String actualClassifiedElement = webDriver.findElement(By.xpath("//*[@id='result']")).getText();

        WebElement generalElement = webDriver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[2]/ol/li[2]/ol/li[4]/span/label/span[1]"));
        generalElement.click();
        String actualGeneralElement = webDriver.findElement(By.xpath("//*[@id='result']")).getText();

        WebElement downloadsElement = webDriver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[3]/span/button"));
        downloadsElement.click();

        WebElement wordFiledocElement = webDriver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[3]/ol/li[1]/span/label/span[1]"));
        wordFiledocElement.click();
        String actualWordFiledocElement = webDriver.findElement(By.xpath("//*[@id='result']")).getText();

        WebElement excelFiledocElement = webDriver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[3]/ol/li[2]/span/label/span[1]"));
        excelFiledocElement.click();
        String actualExcelFiledocElement = webDriver.findElement(By.xpath("//*[@id='result']")).getText();

        WebElement homeElementReturn = webDriver.findElement(By.xpath("//*[@id='tree-node']/ol/li/span/label/span[1]"));
        homeElementReturn.click();
        String actualhomeElementReturn = webDriver.findElement(By.xpath("//*[@id='app']/div/div/div/div[2]/div[3]")).getText();


        String expectedMessageOfNotesElement = "You have selected :\n" + "notes";
        String expectedMessageOfCommandsElement = "You have selected :\n" + "desktop\n" + "notes\n" + "commands";
        String expectedReactElement = "You have selected :\n" + "desktop\n" + "notes\n" + "commands\n" + "react";
        String expectedAngularElement = "You have selected :\n" + "desktop\n" + "notes\n" + "commands\n" + "react\n" + "angular";
        String expectedVeuElement = "You have selected :\n" + "desktop\n" + "notes\n" + "commands\n" + "workspace\n" + "react\n" + "angular\n" + "veu";
        String expectedPublicElement = "You have selected :\n" + "desktop\n" + "notes\n" + "commands\n" + "workspace\n" + "react\n" + "angular\n" + "veu\n" + "public";
        String expectedPrivateElement = "You have selected :\n" + "desktop\n" + "notes\n" + "commands\n" + "workspace\n" + "react\n" + "angular\n" + "veu\n" + "public\n" + "private";
        String expectedClassifiedElement = "You have selected :\n" + "desktop\n" + "notes\n" + "commands\n" + "workspace\n" + "react\n" + "angular\n" + "veu\n" + "public\n" + "private\n" + "classified";
        String expectedGeneralElement = "You have selected :\n" + "desktop\n" + "notes\n" + "commands\n" + "documents\n" + "workspace\n" + "react\n" + "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general";
        String expectedWordFiledocElement = "You have selected :\n" + "desktop\n" + "notes\n" + "commands\n" + "documents\n" + "workspace\n" + "react\n" + "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general\n" + "wordFile";
        String expectedExcelFiledocElement = "You have selected :\n" + "home\n" + "desktop\n" + "notes\n" + "commands\n" + "documents\n" + "workspace\n" + "react\n" + "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general\n" + "downloads\n" + "wordFile\n" + "excelFile";
        String expectedHomeElementReturn = "";


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualMessageOfNotesElement, expectedMessageOfNotesElement, "Несовпадение в MessageOfNotes");
        softAssert.assertEquals(actualMessageOfCommandsElement, expectedMessageOfCommandsElement, "Несовпадение в MessageOfCommands");
        softAssert.assertEquals(actualReactElement, expectedReactElement, "Несовпадение в ReactElement");
        softAssert.assertEquals(actualAngularElement, expectedAngularElement, "Несовпадение в AngularElement");
        softAssert.assertEquals(actualVeuElement, expectedVeuElement, "Несовпадение в VeuElement");
        softAssert.assertEquals(actualPublicElement, expectedPublicElement, "Несовпадение в Public");
        softAssert.assertEquals(actualPrivateElement, expectedPrivateElement, "Несовпадение в Private");
        softAssert.assertEquals(actualClassifiedElement, expectedClassifiedElement, "Несовпадение в Сlassified");
        softAssert.assertEquals(actualGeneralElement, expectedGeneralElement, "Несовпадение в General");
        softAssert.assertEquals(actualWordFiledocElement, expectedWordFiledocElement, "Несовпадение в WordFiledoc");
        softAssert.assertEquals(actualExcelFiledocElement, expectedExcelFiledocElement, "Несовпадение в ExcelFiledoc");
        softAssert.assertEquals(actualhomeElementReturn, expectedHomeElementReturn, "Несовпадение в HomeElementReturn");
        softAssert.assertAll();

        webDriver.quit();


    }


}