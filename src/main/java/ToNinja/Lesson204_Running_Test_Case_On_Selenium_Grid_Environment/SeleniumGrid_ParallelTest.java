package ToNinja.Lesson204_Running_Test_Case_On_Selenium_Grid_Environment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class SeleniumGrid_ParallelTest {
    private WebDriver driver;
    private String baseUrl;
    private String nodeURL;

    SearchPageFactory searchPage;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        baseUrl = "https://www.expedia.com/";
        nodeURL = "http://192.168.108.128:5555/wd/hub";
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setBrowserName("chrome");
        caps.setPlatform(Platform.LINUX);
        driver = new RemoteWebDriver(new URL(nodeURL), caps);

        searchPage = new SearchPageFactory(driver);

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void searchFlights() throws Exception {
        searchPage.clickFlightsTab();
        searchPage.setOriginCity("New York");
        searchPage.setDestinationCity("San Francisco");
        searchPage.setDepartureDate("10/28/2015");
        searchPage.setReturnDate("10/31/2015");
    }

    @AfterClass
    public void tearDown() throws Exception {
        // driver.quit();
    }
}