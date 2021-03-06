package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Barancev_2 {

    public WebDriver driver;
    public String baseURL;
    public WebDriverWait wait;

    @BeforeClass
    public void setUP(){

        driver = new ChromeDriver();
        baseURL = "https://hsreplay.net";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void test(){
        driver.get(baseURL);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}