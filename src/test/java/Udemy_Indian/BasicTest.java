package Udemy_Indian;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

class BasicTest {

    WebDriver driver;
    String baseURL;
    String baseURL2;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        baseURL = "http://google.com.ua";
        baseURL2 = "https://letskodeit.teachable.com/p/practice";
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
        //radioButton
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

    @Test
        //dropDown
    void test5() throws Exception {
        driver.get("https://letskodeit.teachable.com/p/practice");
        WebElement dropDpown = driver.findElement(By.xpath("//select[@id=\"carselect\"]"));
        Select sel = new Select(dropDpown);

        Thread.sleep(2000);
        System.out.println("Select Benz by value");
        sel.selectByValue("benz");

        Thread.sleep(2000);
        System.out.println("Select Honda by value");
        sel.selectByIndex(2);

        Thread.sleep(2000);
        System.out.println("Select Bmw by value");
        sel.selectByVisibleText("BMW");

        List<WebElement> options = sel.getOptions();
        int size = options.size();

        for (int i = 0; i < size; i++) {
            String optionName = options.get(i).getText();
            System.out.println(optionName);
        }

    }

    @Test
        //getTitle, getCurrentUrl
    void test6() {
        driver.get("https://udhtu.edu.ua/en/");
        WebElement a = driver.findElement(By.xpath("//a[@class='icon'][1]"));
        a.click();
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();
        System.out.println(title);
        System.out.println(url);
        driver.quit();
    }

    @Test
        //getAttribute, submit,
    void test7() {
        driver.get(baseURL);
        WebElement search = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
        search.sendKeys("selenium");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]")).submit();
        System.out.println(driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[2]/div/div[1]/input")).getAttribute("Value"));
    }

    @Test
        //Xpath: contains, text. Method - getText
    void test8() {
        driver.get(baseURL);
        WebElement link = driver.findElement(By.xpath("//a[@class=\"gb_d\" and contains (text(),'Gmail')]"));
        System.out.println(link.getText());
        link.click();
        driver.navigate().back();
        WebElement image = driver.findElement(By.xpath("//a[text()='Зображення']"));
        image.click();
    }

    @Test
    //findelements a lot of radio buttons
    void test9 () throws Exception {
        driver.get("https://rozetka.com.ua/notebooks/c80004/filter/producer=apple/");
        /*WebElement m = driver.findElement(By.xpath("//*[@id=\"filter_processor_136402\"]/label/a/span"));
        m.click();
        Thread.sleep(2000);
        WebElement i5 = driver.findElement(By.xpath("//*[@id=\"filter_processor_6269\"]/label/a/span"));
        i5.click();*/
        List<WebElement> processor = driver.findElements(By.xpath("//ul[@id=\"sort_processor\"]//li"));

        int size = processor.size();


        for (int i = 0; i < size; i++ ){
            System.out.println(processor.get(i).getAttribute("textContent"));
        }




    }

    @Test
    // multiple select, selectByValue,
    void test10 () throws Exception{
        driver.get(baseURL2);
        WebElement element = driver.findElement(By.xpath("//select[@name=\"multiple-select-example\"]"));
        Select sel = new Select(element);
        Thread.sleep(2000);

        sel.selectByValue("apple");
        Thread.sleep(2000);

        sel.selectByIndex(1);
        Thread.sleep(2000);

        sel.selectByVisibleText("Peach");
        Thread.sleep(2000);

        sel.deselectByVisibleText("Peach");
        Thread.sleep(2000);

        sel.selectByVisibleText("Peach");
        Thread.sleep(2000);

        List<WebElement> selectedOptions = sel.getAllSelectedOptions();
        for (WebElement option : selectedOptions){
            System.out.println(option.getText());
        }

        Thread.sleep(2000);
        sel.deselectAll();


    }


    @AfterEach
    void tearDown() throws Exception {
        Thread.sleep(2000);
        //driver.close();
        //driver.quit();
    }
}