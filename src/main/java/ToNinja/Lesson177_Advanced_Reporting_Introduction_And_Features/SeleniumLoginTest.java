package ToNinja.Lesson177_Advanced_Reporting_Introduction_And_Features;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import javax.swing.*;

public class SeleniumLoginTest {

    private WebDriver driver;
    private String baseUrl;

    @BeforeClass
    public void beforeClass() {
        baseUrl = "http://www.letskodeit.com/";
        driver = new ChromeDriver();

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test1_validLoginTest() throws Exception {

        Thread.sleep(5000);

        WebElement cross = driver.findElement(By.xpath("//*[@id=\"comp-jgmoxws4\"]"));
        cross.click();

        WebElement signupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
        signupLink.click();

        WebElement loginLink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
        loginLink.click();

        WebElement emailField = driver.findElement(By.xpath("//div[@id='memberLoginDialogemail']//input"));
        emailField.sendKeys("test@email.com");

        WebElement passwordField = driver.findElement(By.xpath("//div[@id='memberLoginDialogpassword']//input"));
        passwordField.sendKeys("abcabc");

        Thread.sleep(3000);

        passwordField.sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        WebElement welcomeText = null;

        try {
            welcomeText = driver.findElement(By.xpath("//div[text()='Hello test']"));
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertTrue(welcomeText != null);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
