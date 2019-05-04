package ToNinja.Lesson114_Clendar_Real_Time;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Practice {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "http://www.expedia.com/";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void test1() throws Exception {
        driver.get(baseUrl);
        // Click flights tab
        driver.findElement(By.id("tab-flight-tab")).click();
        // Find departing field
        WebElement departingField = driver.findElement(By.id("flight-departing"));
        // Click departing field
        departingField.click();
        Thread.sleep(3000);
        // Find the date to be selected
        WebElement dateToSelect = driver.findElement(By.xpath("//section[@class='cal-month'][position()=1]//a[text()='31']"));
        // Click the date
        dateToSelect.click();
    }

    @Test
    public void test2() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("tab-flight-tab")).click();
        WebElement departingField = driver.findElement(By.id("flight-departing"));
        departingField.click();
        WebElement calMonth = driver.findElement(By.xpath("//section[@class='cal-month'][position()=1]"));

        List<WebElement> allValidDates = calMonth.findElements(By.tagName("a"));

        Thread.sleep(3000);

        for (WebElement date : allValidDates) {
            if (date.getText().equals("31")) {
                date.click();
                break;
            }
        }
    }

    @Test
    public void test3() throws Exception {
        boolean isSelected;
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"tab-flight-tab-hp\"]")).click();
        WebElement departingField = driver.findElement(By.xpath("//input[@id=\"flight-departing-hp-flight\"]"));
        departingField.click();
        List<WebElement> list = driver.findElements(By.xpath("//td[@class=\"datepicker-day-number notranslate\"]//button[@data-month=\"4\"]"));
        int size = list.size();

        for (int i = 0; i < size; i++) {
            /*String day = list.get(i).getAttribute("data-day");*/
            isSelected = list.get(i).isSelected();
            if (!isSelected){
                list.get(i).click();
                Thread.sleep(2000);
                departingField.click();
            }






                /*System.out.println("Day " + day + " isn't selected");
                list.get(i).click();
                System.out.println("Click on " + day + " day");
                Thread.sleep(2000);
                departingField.click();

            } else {
                System.out.println("Day " + day + " is selected");
            }*/
            /*String day = list.get(i).getAttribute("data-day");
            System.out.println(day);
            list.get(i).click();
            Thread.sleep(2000);
            departingField.click();*/



            /*String day = list.get(i).getAttribute("data-day");
            if (!list.get(i).isSelected()) {
                list.get(i).click();
                departingField.click();
            } else {
                System.out.println("Something wrong");
            }*/
        }

    }

    @After
    public void tearDown() throws Exception {
        /*Thread.sleep(3000);
        driver.quit();*/
    }
}

