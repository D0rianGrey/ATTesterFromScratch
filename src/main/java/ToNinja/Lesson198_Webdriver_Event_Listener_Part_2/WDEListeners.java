package ToNinja.Lesson198_Webdriver_Event_Listener_Part_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WDEListeners {

    public static void main(String[] args) {
        String baseUrl = "https://www.expedia.com/";
        WebDriver driver = new ChromeDriver();

        EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);
        HandleEvenets he = new HandleEvenets();
        eDriver.register(he);

        eDriver.get(baseUrl);
        eDriver.findElement(By.xpath("//*[@id=\"tab-flight-tab-hp\"]")).click();

    }
}