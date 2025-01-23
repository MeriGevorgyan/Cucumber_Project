package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;

import java.time.Duration;

public class Hooks extends CommonMethods {

    @Before
public void setUp() {
        openBrowserAndLaunchApplication();

}

    @After
    public void tearDown() {
        closeBrowser();
    }
    }

