package Practice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TEst {
    WebDriver driver;
    WebDriverWait wait;
    String baseURL;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseURL = "https://hsreplay.net/";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
        public void testDropdown() throws Exception {
            driver.get(baseURL);
            WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"user-nav\"]/li[1]/a/span[2]"));
            dropdown.click();
            WebElement list = driver.findElement(By.xpath("//*[@id='user-nav]/li[1]/ul"));
            Select sel = new Select(list);
            Thread.sleep(2000);
            sel.selectByValue("Русский");
        }

    @After
        public void tearDown() throws Exception {
                Thread.sleep(2000);
                driver.quit();
            }


}
