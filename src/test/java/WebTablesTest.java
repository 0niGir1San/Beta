import com.demoqa.entities.EmployeeEntity;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends BaseTest {
    @Test
    public void webTablesTest() throws InterruptedException {
        driver.get("https://demoqa.com/webtables");
        webTablesPage.addNewEmployee(randomUtils.generateRandomEmployeeEntities());
        List<EmployeeEntity> employees = webTablesPage.getEmployeesFromTable();
        for (EmployeeEntity employee : employees) {
            System.out.println(employee);
        }


        EmployeeEntity employeeEntity = new EmployeeEntity("Baldwin", "4", "sdyu@gmail.com", 55, 15415, "Dr");
        webTablesPage.editEmployeeByEmail("alden@example.com", employeeEntity);

        // Удаление строки с определенным email
        String emailToDelete = ("cierra@example.com");
        try {
            webTablesPage.deleteRowByEmail(emailToDelete);
            System.out.println("Email " + emailToDelete + " успешно удален из таблицы.");
        } catch (AssertionError | InterruptedException e) {
            System.err.println(e.getMessage());
        }


        // Ожидание для наблюдения за результатами (если нужно)
        webElementActions.waitFor(2000);
    }
}
