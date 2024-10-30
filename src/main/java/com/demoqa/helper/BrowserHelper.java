package com.demoqa.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BrowserHelper {

    private WebDriver driver;

    public BrowserHelper(WebDriver driver){
        this.driver = driver;
    }

    //открыть
    public void open(String url){
        driver.navigate().to(url);
    }

    // назад
    public void goBack(){
        driver.navigate().back();
    }

    // вперед
    public void goForward(){
        driver.navigate().forward();
    }

    // обновить
    public void refreshTgePage(){
        driver.navigate().refresh();
    }

    // Список всех вкладов
    public Set<String> getWindowHandles(){
        return driver.getWindowHandles();
    }

    // Переключается между вкладками
    public void switchToWindow(int index){
        LinkedList<String> windowId = new LinkedList<>(getWindowHandles());

        if (index < 0 || index > windowId.size())
            throw new IllegalArgumentException("Invalid index : " + index);

        driver.switchTo().window(windowId.get(index));
    }

    // Переключаемся на последнюю (новую) вкладку
    public void switchToNewTab() {
        // Получаем список всех доступных вкладок
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    // Переключаемся на новую вкладку по ссылке
    public void openNewTab(String url) {
        // Открыть новую вкладку с помощью JavaScript
        ((JavascriptExecutor) driver).executeScript("window.open('" + url + "', '_blank');");

        // Получить список всех доступных вкладок
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // Переключиться на новую вкладку
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    // Метод для ожидания загрузки страницы
    public void waitPageLoad() {
        try {
            Thread.sleep(3000); // Время для загрузки страницы
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    // Вернись в родительскую вкладку
    public void switchToParentWindow(){
        LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());
        driver.switchTo().window(windowsId.get(0));
    }

    public void switchToParentWindowChildClose(){
        switchToParentWindow();
        LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());

        for (int i = 1; i < windowsId.size() ; i++){
            driver.switchTo().window(windowsId.get(i));
            driver.close();
        }

        switchToParentWindow();
    }

    public void newTab() {
        // Открываем новую вкладку в браузере с помощью JavaScript
        ((JavascriptExecutor) driver).executeScript("window.open()");
    }


}
