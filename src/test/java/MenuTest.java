import org.testng.annotations.Test;

public class MenuTest extends BaseTest {

    @Test
    public void moveToElementTest() throws InterruptedException {
        browserHelper.open("https://demoqa.com/menu");
        webElementActions.moveToElement(menuPage.mainItem2);
        webElementActions.moveToElement(menuPage.subSubList);


    }

}
