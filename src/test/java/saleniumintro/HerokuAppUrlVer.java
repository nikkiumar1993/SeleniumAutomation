package saleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HerokuAppUrlVer {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" https://the-internet.herokuapp.com/forgot_password");
        driver.findElement(By.id("email")).sendKeys("nikkiumar@gmail.com");
        driver.findElement(By.id("form_submit")).click();
        String expectedUrl = "email_sent";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl)){
            System.out.println("Url verification passed");
        }else{
            System.out.println("Url verification failed");
        }
        String actualTextBoxValue = driver.findElement(By.id("content")).getText();
        String expectedTextBoxValue = "Your e-mail's been sent!";
        if(actualTextBoxValue.equals(expectedTextBoxValue)){
            System.out.println("Text box value verification passes");
        }else{
            System.out.println("Text box value verification failed");
        }


    }
}
