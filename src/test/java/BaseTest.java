import com.demoqa.drivers.DriverManager;
import com.demoqa.helper.AlertHelper;
import com.demoqa.helper.BrowserHelper;
import com.demoqa.helper.IframeHelper;
import com.demoqa.helper.WebElementActions;
import com.demoqa.pages.*;
import com.demoqa.utils.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;
    protected RandomUtils randomUtils;
    protected WebElementActions webElementActions;

    protected AlertHelper alertHelper;
    protected BrowserHelper browserHelper;
    protected IframeHelper iframeHelper;

    protected TextBoxPage textBoxPage;
    protected PracticeFormPage practiceFormPage;
    protected AlertPage alertPage;
    protected ButtonsPage buttonsPage;
    protected MenuPage menuPage = new MenuPage();
    protected ProgressBarPage progressBarPage;
    protected SelectMenuPage selectMenuPage;
    protected WebTablesPage webTablesPage;


    @BeforeClass(alwaysRun = true)
    public void setUp(){
        driver = DriverManager.getDriver();
        randomUtils = new RandomUtils();
        webElementActions = new WebElementActions(driver);

        alertHelper = new AlertHelper(driver);
        browserHelper = new BrowserHelper(driver);
        iframeHelper = new IframeHelper(driver);

        textBoxPage = new TextBoxPage();
        practiceFormPage = new PracticeFormPage();
        alertPage = new AlertPage();
        buttonsPage = new ButtonsPage();
        menuPage = new MenuPage();
        progressBarPage = new ProgressBarPage();
        selectMenuPage = new SelectMenuPage();
        webTablesPage = new WebTablesPage();
        iframeHelper = new IframeHelper(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        DriverManager.closeDriver();
    }
}