import org.testng.Assert;
import org.testng.annotations.Test;

public class ProgressBarTest extends BaseTest {

    @Test
    public void progressBarTest() throws InterruptedException {
        // Открываем страницу с progress bar
        browserHelper.open("https://demoqa.com/progress-bar");

        // Нажимаем кнопку "Start"
        webElementActions.click(progressBarPage.startStopButton);

        // Устанавливаем максимальное время ожидания в миллисекундах
        long maxWaitTime = 10000; // 10 секунд
        long startTime = System.currentTimeMillis();
        String actualValue = "";

        // Ожидание, пока значение progress bar не станет 52 или время ожидания не превысит лимит
        while (true) {
            actualValue = progressBarPage.aria_valuenow.getAttribute("aria-valuenow");
            if ("52".equals(actualValue)) {
                break;
            }
            if (System.currentTimeMillis() - startTime > maxWaitTime) {
                break;
            }
            Thread.sleep(100); // Пауза на 100 миллисекунд перед следующей проверкой
        }

        // Останавливаем progress bar
        webElementActions.click(progressBarPage.startStopButton);

        String expectedValue = "52"; // Ожидаемое значение в виде строки

        // Выводим значения в консоль для отладки
        System.out.println("Actual value: " + actualValue);
        System.out.println("Expected value: " + expectedValue);

        // Сравниваем фактическое и ожидаемое значения
        Assert.assertEquals(actualValue, expectedValue, "Значение progress bar не соответствует ожидаемому");
    }
}
