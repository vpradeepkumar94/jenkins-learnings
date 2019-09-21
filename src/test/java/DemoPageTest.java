import enums.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static utils.Util.takeSnapShot;

public class DemoPageTest {

    private WebDriver driver;

    @Test
    public void testEasy() throws Exception {
        driver.get(Prop.getValue(Constants.base_uri));
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Demo Guru99 Page"));
        takeSnapShot(driver,"home.png");
    }
    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
