package saleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBankHeaderVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" http://zero.webappsecurity.com/login.html");
        String actualHeader = driver.findElement(By.className("page-header")).getText();
        String expectedTextHeader = "Log in to ZeroBank";

        if(actualHeader.equals(expectedTextHeader)){
            System.out.println("Header verification passed");
        }else{
            System.out.println("Header verification failed");
        }

    }
}
