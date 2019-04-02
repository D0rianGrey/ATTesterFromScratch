import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

class BasicTest {

    WebDriver driver;
    String baseURL;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        baseURL = "http://google.com.ua";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    void test() {
        driver.get(baseURL);
        WebElement w1 = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
        System.out.println("Enabled ?" + w1.isEnabled());
        WebElement button = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]"));
        w1.sendKeys("selenium");
        button.click();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());
        /////
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[2]/div/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[2]/div/div[1]/input")).sendKeys("selenide");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[2]/button")).click();
    }

    @Test
    void test2() {
        driver.get(baseURL);
        String title = driver.getTitle();
        System.out.println("Title of the page is " + title);

        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL is " + currentURL);
    }

    @Test
    void test3() throws Exception {
        driver.get("https://letskodeit.teachable.com/p/practice");
        WebElement bmwRadio = driver.findElement(By.xpath("//*[@id=\"bmwradio\"]"));
        bmwRadio.click();
        Thread.sleep(2000);
        WebElement benzRadio = driver.findElement(By.xpath("//*[@id=\"benzradio\"]"));
        benzRadio.click();
        Thread.sleep(2000);
        WebElement hondaRadio = driver.findElement(By.xpath("//*[@id=\"hondaradio\"]"));


        WebElement bmwCheckBox = driver.findElement(By.xpath("//*[@id=\"bmwcheck\"]"));
        bmwCheckBox.click();
        Thread.sleep(2000);
        WebElement benzCheckBox = driver.findElement(By.xpath("//*[@id=\"benzcheck\"]"));
        benzCheckBox.click();
        Thread.sleep(2000);
        WebElement hondaCheckBox = driver.findElement(By.xpath("//*[@id=\"hondacheck\"]"));


        System.out.println("BmwRadio selected? " + bmwRadio.isSelected());
        System.out.println("BenzRadio selected? " + benzRadio.isSelected());
        System.out.println("HondaRadio selected? " + hondaRadio.isSelected());

        System.out.println("BmwCheckBox selected? " + bmwCheckBox.isSelected());
        System.out.println("BenzCheckBox selected? " + benzCheckBox.isSelected());
        System.out.println("HondaCheckBox selected? " + hondaCheckBox.isSelected());

    }

    @Test
    void test4() throws Exception {
        boolean isChecked;
        driver.get("https://letskodeit.teachable.com/p/practice");
        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[contains(@type, 'radio') and contains(@name, 'cars')]"));
        int size = radioButtons.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            isChecked = radioButtons.get(i).isSelected();
            if (!isChecked) {
                radioButtons.get(i).click();
                Thread.sleep(2000);
                System.out.println("Батон не выбран, поэтому кликаю");
            }


        }

    }


    @AfterEach
    void tearDown() throws Exception {
        Thread.sleep(2000);
        //driver.close();
        //driver.quit();
    }
}