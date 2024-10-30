import com.demoqa.entities.PracticeFormEntity;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeFormTest extends BaseTest{

    @Test
    public void textBoxText(){
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        PracticeFormEntity practicFormEntity = randomUtils.generateRandomPracticeFormEntity();
        practiceFormPage.fillUpPracticeForm(practicFormEntity);
    }
}

