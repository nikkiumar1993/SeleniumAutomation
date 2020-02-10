package saleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBankLinkVer {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" http://zero.webappsecurity.com/login.html");
     String actualLink = driver.findElement(By.linkText("Forgot your password ?")).getAttribute("href");
     String expectedLink = "/forgot-password.html";
     if(actualLink.contains(expectedLink)){
         System.out.println("Attribute value verification passed");
     }else{
         System.out.println("Attribute value verification failed");
     }
    }
}
