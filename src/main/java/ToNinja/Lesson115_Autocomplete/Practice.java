package ToNinja.Lesson115_Autocomplete;

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
    private String baseURL;

    @Before
    public void setUP(){
        driver = new ChromeDriver();
        baseURL = "https://booking.uz.gov.ua/ru/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test(){
        driver.get(baseURL);
        String searchingText = "Львов";
        String partialText = "льв";

        WebElement input = driver.findElement(By.xpath("/html/body/div[1]/div[1]/form/div[2]/div[1]/div[1]/input"));
        input.sendKeys(partialText);

        WebElement root = driver.findElement(By.xpath("//*[@id=\"from-autocomplete\"]"));

        List<WebElement> allOptions = root.findElements(By.tagName("li"));

        System.out.println(allOptions.size());

        for(WebElement result: allOptions){
                if (result.getText().equals(searchingText)){
                    result.click();
                }

        }


    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
