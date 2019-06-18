package ToNinja.Lesson183_Exercise_With_Solution_Homework;

import org.openqa.selenium.*;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {

    ExtentTest test;
    WebDriver driver = null;

    public HomePage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
    }

    public void clickCross(){
        WebElement cross = driver.findElement(By.xpath("//*[@id=\"comp-jgmoxws4\"]"));
        cross.click();
        test.log(LogStatus.INFO,"Clicked on cross icon");
    }

    public void clickSignUpLink() {
        WebElement signupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
        signupLink.click();
        test.log(LogStatus.INFO, "Clicked on signup link");
    }

    public void clickLoginLink() {
        WebElement loginLink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
        loginLink.click();
        test.log(LogStatus.INFO, "Clicked on login link");
    }

    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.xpath("//div[@id='memberLoginDialogemail']//input"));
        emailField.sendKeys(email);
        test.log(LogStatus.INFO, "Enter email");
    }

    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.xpath("//div[@id='memberLoginDialogpassword']//input"));
        passwordField.sendKeys(password);
        test.log(LogStatus.INFO, "Enter password");
    }

    public void clickGoLink() {
        WebElement goButton = driver.findElement(By.xpath("//div[@id='memberLoginDialogpassword']//input"));
        goButton.click();
        goButton.sendKeys(Keys.ENTER);
        test.log(LogStatus.INFO, "Clicked Go button");
    }

    public boolean isWelcomeTextPresent() {
        WebElement welcomeText = null;
        try {
            welcomeText = driver.findElement(By.xpath("//div[text()='Hello test']"));
            if (welcomeText != null) {
                return true;
            }
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

    public void login(String email, String password) throws InterruptedException {
        Thread.sleep(5000);
        clickCross();
        clickSignUpLink();
        clickLoginLink();
        enterEmail(email);
        enterPassword(password);
        clickGoLink();
    }
}