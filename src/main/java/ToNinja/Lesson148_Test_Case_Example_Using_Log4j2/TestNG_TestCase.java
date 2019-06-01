package ToNinja.Lesson148_Test_Case_Example_Using_Log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestNG_TestCase {
    private WebDriver driver;

    private String baseUrl;
    private static final Logger log = LogManager.getLogger(TestNG_TestCase.class.getName());

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        baseUrl = "https://letskodeit.teachable.com";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void testMethod() throws Exception {
        log.info("This message is from test method");
    }

    @AfterClass
    public void afterClass() {
    }
}