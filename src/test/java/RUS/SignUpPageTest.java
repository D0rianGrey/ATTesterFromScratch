package RUS;

import RUS.Page_Object.MainPage;
import RUS.Page_Object.SignUpPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {

    WebDriver driver;
    SignUpPage signUpPage;
    MainPage mainPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");
        signUpPage = new SignUpPage(driver);
        mainPage = new MainPage(driver);
    }

    @Test
    public void signUpWithShortPass() {
        signUpPage = mainPage.register("f", "f", "f");
        String error = signUpPage.getPasswordErrorText();
        Assert.assertEquals("Password is too short (minimum is 8 characters), needs at least 1 number, cannot include your login, and is weak and can be easily guessed", error);
    }

    @Test
    public void signUpReservedUsernameTest() {
        String x = "username";
        signUpPage = mainPage.register(x, "f", "f");
        String error = signUpPage.getUsernameErrorText();
        Assert.assertEquals("Login '" + x + "' is unavailable", error);
    }

    @Test
    public void signUpTakenUsername() {
        signUpPage = mainPage.register("user", "f", "f");
        String error = signUpPage.getUsernameErrorText();
        Assert.assertEquals("Login is already taken", error);
    }

    @Test
    public void getHeadingTest() {
        driver.get("https://github.com/join");
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub", heading);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

