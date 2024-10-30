import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BrowserHelperTest extends BaseTest {
    @Test
    void test123() throws InterruptedException {
        browserHelper.open("https://demoqa.com/browser-windows");
        driver.findElement(By.id("tabButton")).click();
        browserHelper.switchToWindow(0);
        driver.findElement(By.id("tabButton")).click();
        browserHelper.switchToWindow(0);
        driver.findElement(By.id("tabButton")).click();
        browserHelper.switchToWindow(0);
        driver.findElement(By.id("tabButton")).click();
        browserHelper.switchToWindow(4);
        browserHelper.switchToParentWindowChildClose();
    }
}
