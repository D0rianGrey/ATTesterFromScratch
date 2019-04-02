import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String baseURL = "https://www.google.com.ua/";
        driver.get(baseURL);
        WebElement w1 = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
        WebElement button = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]"));
        w1.sendKeys("selenium");
        button.click();
        driver.close();

    }
}
