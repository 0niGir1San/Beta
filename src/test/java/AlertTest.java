import com.demoqa.enums.Endpoints;
import com.demoqa.utils.ConfigReader;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest{

    @Test
    void alertTest() {
        browserHelper.open(ConfigReader.getValue("baseURL") + Endpoints.ALERT.getEndpoint());
        webElementActions.click(alertPage.confirmButton);
        alertHelper.acceptAlert();
        webElementActions.pause(2000);
    }
}
