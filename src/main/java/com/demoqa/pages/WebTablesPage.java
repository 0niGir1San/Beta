package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.entities.EmployeeEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WebTablesPage extends BasePage {

    @FindBy(id = "addNewRecordButton")
    public WebElement addNewEmployeeBtn;

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "userEmail")
    public WebElement userEmailInput;

    @FindBy(id = "age")
    public WebElement ageInput;

    @FindBy(id = "salary")
    public WebElement salaryInput;

    @FindBy(id = "department")
    public WebElement departmentInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    @FindBy(xpath = ".//span[@title='Delete']")
    public WebElement deleteButtonLocator;

    @FindBy(xpath = ".//span[@title='Edit']")
    public WebElement editButtonLocator;


    // добавляет нового сотрудника в таблицу
    public WebTablesPage addNewEmployee(EmployeeEntity employee) {

        // Проверка на наличие такого email в таблице
        if (isEmployeeWithEmailExists(employee.getEmail())) {
            System.out.println("Сотрудник с email " + employee.getEmail() + " уже существует в таблице. Пропускаем добавление.");
            return this;
        }

        webElementActions.click(addNewEmployeeBtn)
                .sendKeys(firstNameInput, employee.getFirstName())
                .sendKeys(lastNameInput, employee.getLastName())
                .sendKeys(userEmailInput, employee.getEmail())
                .sendKeys(ageInput, String.valueOf(employee.getAge()))
                .sendKeys(salaryInput, String.valueOf(employee.getSalary()))
                .sendKeys(departmentInput, employee.getDepartment())
                .click(submitBtn);
        return this;
    }


    // Проверяет есть ли сотрудник с заданным email в таблице.
    private boolean isEmployeeWithEmailExists(String email) {
        List<EmployeeEntity> employees = getEmployeesFromTable();
        for (EmployeeEntity employee : employees) {
            if (employee.getEmail().equals(email)) {
                return true; //есть
            }
        }
        return false; //нет
    }


    // Выводит все данные строки
    public ArrayList<EmployeeEntity> getEmployeesFromTable() {
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));

        ArrayList<EmployeeEntity> employees = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            String firstName = cells.get(0).getText();
            String lastName = cells.get(1).getText();
            String ageText = cells.get(2).getText().replace("[^0-9]","");
            String email = cells.get(3).getText();
            String salaryText = cells.get(4).getText().replace("[^0-9]","");
            String department = cells.get(5).getText();

            if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || email.isEmpty() ||
                    salaryText.isEmpty() || department.isEmpty() ){
                continue;
            }

            try {
                int age = Integer.parseInt(ageText);
                long salary = Long.parseLong(salaryText);

                employees.add(new EmployeeEntity(firstName, lastName, email, age, salary, department));
            } catch (NumberFormatException e) {
                System.err.println("Ошибка преобразования текста в число для строки: " + row.getText());
            }

        }
        return employees;
    }


    // Нажимает кнопку удаления
    private void deleteRow(WebElement row) {
        Actions actions = new Actions(driver);

        WebElement deleteButton = deleteButtonLocator;
        actions.moveToElement(deleteButton).build().perform();
        actions.click(deleteButton).build().perform();

    }

    // Метод для нахождения всех строк таблицы
    public List<WebElement> findRows() {
        return driver.findElements(By.cssSelector(".ReactTable .rt-tr-group"));
    }

    // Удаляет заданный email
    public void deleteRowByEmail(String emailToDelete) throws InterruptedException {
        List<WebElement> rows = findRows();
        boolean emailFound = false;

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            for (WebElement cell : cells) {
                String cellText = cell.getText();
                if (cellText.equals(emailToDelete)) {
                    deleteRow(row);
                    emailFound = true;
                    break;
                }
            }
            if (emailFound) {
                break;
            }
        }

        if (!emailFound) {
            throw new AssertionError("Email address " + emailToDelete + " not found in the table");
        }
    }

    // Нажимает кнопку редактирования
    public void editRow(WebElement edit){
        Actions actions = new Actions(driver);

        WebElement editButton = editButtonLocator;
        actions.moveToElement(editButton).build().perform();
        actions.click(editButton).build().perform();

    }

    // Метод для редактирования данных сотрудника по email
    public void editEmployeeByEmail(String emailToEdit, EmployeeEntity updatedEmployee) throws InterruptedException {
        List<WebElement> rows = findRows();
        boolean emailFound = false;

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            for (WebElement cell : cells) {
                String cellText = cell.getText();
                if (cellText.equals(emailToEdit)) {
                    emailFound = true;
                    // Нажимаем кнопку редактирования для найденной строки
                    WebElement editButton = row.findElement(By.xpath(".//span[@title='Edit']"));
                    editButton.click();

                    // Ожидание загрузки формы редактирования
                    Thread.sleep(2000); // рекомендуется заменить на WebDriverWait

                    // Заполняем форму с новыми данными
                    WebElement firstNameInput = driver.findElement(By.id("firstName"));
                    WebElement lastNameInput = driver.findElement(By.id("lastName"));
                    WebElement userEmailInput = driver.findElement(By.id("userEmail"));
                    WebElement ageInput = driver.findElement(By.id("age"));
                    WebElement salaryInput = driver.findElement(By.id("salary"));
                    WebElement departmentInput = driver.findElement(By.id("department"));
                    WebElement submitBtn = driver.findElement(By.id("submit"));

                    firstNameInput.clear();
                    firstNameInput.sendKeys(updatedEmployee.getFirstName());

                    lastNameInput.clear();
                    lastNameInput.sendKeys(updatedEmployee.getLastName());

                    userEmailInput.clear();
                    userEmailInput.sendKeys(updatedEmployee.getEmail());

                    ageInput.clear();
                    ageInput.sendKeys(String.valueOf(updatedEmployee.getAge()));

                    salaryInput.clear();
                    salaryInput.sendKeys(String.valueOf(updatedEmployee.getSalary()));


                    departmentInput.clear();
                    departmentInput.sendKeys(updatedEmployee.getDepartment());

                    // Нажать кнопку Submit для сохранения изменений
                    submitBtn.click();

                    System.out.println("Employee with email " + emailToEdit + " Данные успешно изменены" );
                    break;
                }
            }
            if (emailFound) {
                break;
            }
        }

        if (!emailFound) {
            throw new AssertionError("Email address " + emailToEdit + " not found in the table");
        }
    }

}

