package ToNinja.Lesson187_Multiple_Data_Sets_Test_Case_Practical_Example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UsingExcel {
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        driver = new ChromeDriver();

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Constants.URL);

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"comp-jgmoxws4\"]")).click();
        driver.findElement(By.xpath("//span[text()='Learn Now']")).click();
        driver.findElement(By.xpath("//div[@id='navbar']//a[contains(text(),'Login')]")).click();
        // Tell the code about the location of Excel file
        ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "LoginTests");
    }

    @DataProvider(name = "loginData")
    public Object[][] dataProvider() {
        Object[][] testData = ExcelUtility.getTestData("Invalid_Login");
        return testData;
    }

    @Test(dataProvider="loginData")
    public void testUsingExcel(String username, String password) throws Exception {
        // Click login button
       /* WebElement login = driver.findElement(By.xpath("//div[@id='navbar']//a[contains(text(),'Login')]"));
        if (login.isDisplayed()){
            login.click();
        } else {
            System.out.println("There isn't fucking button");
        }*/
        Thread.sleep(2000);
        /*driver.findElement(By.xpath("//div[@id='navbar']//a[contains(text(),'Login')]")).click();
        Thread.sleep(2000);*/
        // Enter username
        driver.findElement(By.id("user_email")).sendKeys(username);
        Thread.sleep(2000);
        // Enter password
        driver.findElement(By.id("user_password")).sendKeys(password);
        Thread.sleep(2000);
        // Click Login button
        driver.findElement(By.name("commit")).click();
        Thread.sleep(2000);
        //Clear email field
        driver.findElement(By.id("user_email")).clear();
        Thread.sleep(2000);

        // Find if error messages exist
        boolean result = driver.findElements(By.xpath("//div[@class=\"alert alert-danger\" and contains(text(),\"Invalid email or password.\")]")).size() != 0;
        Assert.assertTrue(result);
    }

    @AfterClass
    public void tearDown() throws Exception {
        //driver.quit();
    }
}
