package ToNinja.Lesson91_ElementState;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementState {
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com";
        driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void test() {
        WebElement e1 = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
        WebElement button = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]"));
        System.out.println("E1 is Enabled? " + e1.isEnabled());
        if (e1.isEnabled()){
            e1.sendKeys("Selenium");
            button.click();
            System.out.println(driver.getTitle());
            if(driver.getTitle().equals("Selenium - Пошук Google")){
                System.out.println("All is OK");
            } else {
                System.out.println("Something is wrong again");
            }
        } else {
            System.out.println("Something wrong");
        }

        //WebElement e2 = driver.findElement(By.id("gs_taif0"));
        //System.out.println("E2 is Enabled? " + e2.isEnabled());

        //WebElement e3 = driver.findElement(By.id("lst-ib"));
        //System.out.println("E3 is Enabled? " + e3.isEnabled());
    }

    @After
    public void tearDown() throws Exception {
        //Thread.sleep(2000);
        //driver.quit();
    }
}