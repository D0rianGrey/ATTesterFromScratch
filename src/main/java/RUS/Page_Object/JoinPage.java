package RUS.Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JoinPage {

    private WebDriver driver;

    public JoinPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = By.xpath(".//*[@id='login_field']");
    private By passwordField = By.xpath(".//*[@id='password']");
    private By signInButton = By.xpath("//input[@type='submit']");
    private By heading = By.xpath("//div[contains(@class, 'auth-form-header')]/h1");
    private By error = By.xpath(".//*[@id='js-flash-container']//div[@class='container']");
    private By createAccLink = By.xpath("//*[@id=\"login\"]/p/a");

    private By textOnJoin = By.xpath("//*[contains(text(),\"The best way to design, build, and ship software.\")]");


    public JoinPage typeUsername(String username){
        driver.findElement(loginField).sendKeys(username);
        return this;
    }

    public JoinPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public JoinPage loginWithInvalidCreds(String username, String password){
        this.typeUsername(username);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new JoinPage(driver);
    }

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public String getErrorText(){
        return driver.findElement(error).getText();
    }

    public SignUpPage createAccount(){
        driver.findElement(createAccLink).click();
        return new SignUpPage(driver);
    }

    public String getTextOnTheTop(){
        return driver.findElement(textOnJoin).getText();
    }






}
