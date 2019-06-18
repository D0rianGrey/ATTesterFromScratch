package ToNinja.Lesson192_File_Upload_Windows_Robot;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class FileUploadWindows {
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
    public void fileUpload() throws AWTException, InterruptedException {
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

        StringSelection ss = new StringSelection("C:\\Users\\Eugene\\Desktop\\testfile.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        // Ctrl + v
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        driver.findElement(By.xpath("//div[text()='Send']")).click();
    }

    @AfterClass
    public void afterClass() {
    }

}