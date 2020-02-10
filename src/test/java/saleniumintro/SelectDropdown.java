package saleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SelectDropdown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement website = driver.findElement(By.id("dropdownMenuLink"));
       website.click();
       WebElement facebook = driver.findElement(By.xpath("//a[.='Facebook']"));
       facebook.click();
       String expectedTille = "Facebook - Log In or Sign Up";
       String actualTitle = driver.getTitle();
       if (expectedTille.equals(actualTitle)){
           System.out.println("Expected title verification PASSED");
       }else {
           System.out.println("Expected title verification FAILED");
       }


    }
}
