package ToNinja.Lesson155_Method_And_Class_Annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestNG_MethodClassAnnotations {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.out.println("\nThis runs once before class");
        driver = new ChromeDriver();

    }

    @AfterClass
    public void cleanUp() {
        System.out.println("\nThis runs once after class");
        driver.close();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("\nThis runs before every method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("\nThis runs after every method");
    }

    @Test
    public void testMethod1() {
        System.out.println("\nRunning Test -> testMethod1");
        driver.get("https://www.google.com.ua/");
    }

    @Test
    public void testMethod2() {
        System.out.println("\nRunning Test -> testMethod2");
    }
}
