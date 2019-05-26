package ToNinja.Lesson133_KeyPress_Events_Using_Actions_Class;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class KeyPressDemo3 {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://letskodeit.teachable.com/p/practice";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testKeyPress() throws Exception {
        driver.get(baseUrl);
        Thread.sleep(3000);

        Actions action = new Actions(driver);
        action.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
    }

    @After
    public void tearDown() throws Exception {
        // driver.quit();
    }
}
