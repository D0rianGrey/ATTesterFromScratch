package RUS;

import RUS.Page_Object.JoinPage;
import RUS.Page_Object.SignUpPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JoinPageTest {

    private WebDriver driver;
    private JoinPage joinPage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
        joinPage = new JoinPage(driver);
    }

    @Test
    public void loginWithEmptyCredsTest(){
        JoinPage newLoginPage =  joinPage.loginWithInvalidCreds("","");// мы получаем newLoginPage при выполнении метода loginWithInvalidCrerds
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void loginWithIncorrectCredsTest(){
        JoinPage newLoginPage =  joinPage.loginWithInvalidCreds("qweqewqwe","qweqweweqwe");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void createAccTest(){
        SignUpPage signUpPage = joinPage.createAccount(); // создадим обьект класа SinUpPage, для этого мы выполним метод createAccount
        String heading = signUpPage.getHeadingText(); // когда попадем на SignUpPage выполним метод getHeadingText и запишем его в переменную heading типа String
        Assert.assertEquals("Join GitHub", heading); // указываем заголовок реальный и который лежит в переменной heading и сравниваем их
    }

    @After
    public void tearDown(){
        //driver.quit();
    }
}

