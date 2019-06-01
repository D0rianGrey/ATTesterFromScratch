package UDHTU;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    WebDriver driver;
    String baseURL;



    @BeforeEach
    void setUp (){
        driver = new ChromeDriver();
        baseURL = "https://udhtu.edu.ua/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        }

    @Test
    void test (){
        driver.get(baseURL);


    }

    @AfterEach
    void tearDown(){
        //driver.quit();
    }


}
