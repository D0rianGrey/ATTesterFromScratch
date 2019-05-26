package ToNinja.Lesson116_Capturing_Screenshots;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Screenshots {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://www.expedia.com/";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testScreenshots() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"tab-flight-tab-hp\"]")).click(); // переходим на табу flights
        WebElement flight_origin = driver.findElement(By.xpath("//*[@id=\"flight-origin-hp-flight\"]"));// находим поле вылета
        flight_origin.click();
        flight_origin.sendKeys("New York");

        //2

        WebElement flight_destination = driver.findElement(By.xpath("//*[@id=\"flight-destination-hp-flight\"]")); //куда летим
        flight_destination.click();
        flight_destination.sendKeys("New York");

        //3

        WebElement departure_date = driver.findElement(By.xpath("//*[@id=\"flight-departing-hp-flight\"]")); // дата вылета
        departure_date.click();
        departure_date.sendKeys("09/03/2014");

        //4

        WebElement return_date = driver.findElement(By.xpath("//*[@id=\"flight-returning-hp-flight\"]"));
        return_date.click();
        Thread.sleep(3000);

        //5
        WebElement search = driver.findElement(By.xpath("//*[@id=\"gcw-flights-form-hp-flight\"]/div[7]/label/button"));
        search.submit();

    }

    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    @After
    public void tearDown() throws Exception {
        String fileName = getRandomString(10) + ".png";
        String directory = "D:\\Screenshots\\";

        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + fileName));
        driver.quit();
    }
}
