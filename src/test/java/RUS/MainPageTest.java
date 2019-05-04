package RUS;

import RUS.Page_Object.JoinPage;
import RUS.Page_Object.MainPage;
import RUS.Page_Object.SignUpPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://github.com");
        mainPage = new MainPage(driver);
    }

    @Test
    public void signInTest(){
        JoinPage joinPage = mainPage.clickSignIn(); // что бы нажать на кнопку, нам надо создать обьект страницы JoinPage joinPage (на которую мы попадем), но нажимать мы будем путем метода, который относится к MainPage странице, но возвращает JoinPage
        String heading = joinPage.getHeadingText(); // проверяем текст который находится уже на странице JoinPage
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void registerFailTest(){
        SignUpPage signUpPage = mainPage.register("testuser", "testemail", "testpass");// создаем страницу (обьект класса) SignUpPage (SignUpPage signUpPage) на которую мы перейдем путем метода register, который описан на странице  MainPage
        String error = signUpPage.getMainErrorText(); // когда мы уже попали на страницу SignUpPage, мы можем  проверить тест главной ошибке
        Assert.assertEquals("There were problems creating your account.", error);
    }

    @Test
    public void signUpEmptyUsernameTest(){
        SignUpPage signUpPage = mainPage.register("", "mail", "pass");
        String error = signUpPage.getUsernameErrorText();
        Assert.assertEquals("Login can't be blank", error);
    }

    @Test
    public void signUpInvalidEmailTest(){
        SignUpPage signUpPage = mainPage.register("qeqwe", "qweq", "pass");
        String error = signUpPage.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }

    @After
    public void tearDown(){
        //driver.quit();
    }
}
