package ToNinja.Lesson248_Sauce_Labs_Practical_Example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabsDemo {
    private WebDriver driver;

    @Test
    @DisplayName("shouldOpenSafari()")
    public void shouldOpenSafari(TestInfo testInfo) throws MalformedURLException, InterruptedException {
        /**
         * In this section, we will configure our SauceLabs credentials in order to run our tests on saucelabs.com
         */
        String sauceUserName = "utyfdfrthby08";
        String sauceAccessKey = "fe69e452-5318-4908-a6b5-364ead6b6f16";

        /**
         * In this section, we will configure our test to run on some specific
         * browser/os combination in Sauce Labs
         */
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //set your user name and access key to run tests in Sauce
        capabilities.setCapability("username", sauceUserName);

        //set your sauce labs access key
        capabilities.setCapability("accessKey", sauceAccessKey);

        //set browser to Safari
        capabilities.setCapability("browserName", "Safari");

        //set operating system to macOS version 10.13
        capabilities.setCapability("platform", "macOS 10.13");

        //set the browser version to 11.1
        capabilities.setCapability("version", "11.1");

        //set your test case name so that it shows up in Sauce Labs
        capabilities.setCapability("name", testInfo.getDisplayName());

        driver = new RemoteWebDriver(new URL("http://ondemand.eu-central-1.saucelabs.com/wd/hub"), capabilities);

        driver.get("https://letskodeit.teachable.com/p/practice");
        System.out.println("title of page is: " + driver.getTitle());

        Thread.sleep(3000);


        driver.quit();

    }

}