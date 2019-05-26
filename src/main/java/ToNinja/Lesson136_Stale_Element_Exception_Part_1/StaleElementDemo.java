package ToNinja.Lesson136_Stale_Element_Exception_Part_1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StaleElementDemo {

    @Test
    public void testMethod() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://learn.letskodeit.com/p/practice");

        driver.get(driver.getCurrentUrl());
        WebElement checkboxElement = driver.findElement(By.id("bmwcheck"));
        checkboxElement.click();
    }
}
