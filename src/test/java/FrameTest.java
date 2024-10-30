import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest{

    @Test(description = "Smoke")
    public void iframeTest(){
        browserHelper.open("https://demoqa.com/frames");
        iframeHelper.switchToFrame("frame1");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        iframeHelper.switchToParentFrame();
        System.out.println(driver.findElement(By.tagName("h1")).getText());
    }
}
