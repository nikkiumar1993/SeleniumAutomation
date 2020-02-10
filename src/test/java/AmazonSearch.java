import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
  WebElement wb = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
  wb.sendKeys("iphone");
  driver.findElement(By.cssSelector("#nav-search > form > div.nav-right > div > input")).click();


    }
}
