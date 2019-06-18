package ToNinja.Lesson195_File_Upload_Windows_AutoIT;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class FileUploadWindowsAutoIT {
    private WebDriver driver;
    private String baseUrl;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        baseUrl = "https://www.gmail.com/";
        driver = new ChromeDriver();

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void fileUpload() throws AWTException, InterruptedException, IOException {
        WebElement email = driver.findElement(By.xpath("//input[@type=\"email\"]"));
        email.sendKeys("jenkins1991automation");

        WebElement next = driver.findElement(By.xpath("//span[@class=\"RveJvd snByac\" and contains(text(),\"Далі\")]"));
        next.click();

        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type=\"password\"]"))).sendKeys("Q852456357159q");

        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"RveJvd snByac\" and contains(text(),\"Далі\")]"))).click();

        driver.findElement(By.xpath("//div[@class=\"T-I J-J5-Ji T-I-KE L3\"]")).click();
        driver.findElement(By.xpath("//div[@class='wO nr l1']//textarea")).sendKeys("utyfdfrthby08@gmail.com");
        driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Test File Upload");
        WebElement fileInput = driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']"));
        fileInput.click();

        Thread.sleep(2000);
        Runtime.getRuntime().exec("C:\\Users\\Eugene\\Desktop\\fileupload.exe");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[text()='Send']")).click();
    }

    @AfterClass
    public void afterClass() {
    }

}