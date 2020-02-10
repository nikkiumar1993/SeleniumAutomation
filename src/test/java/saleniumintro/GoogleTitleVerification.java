package saleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTitleVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("https://www.google.com");
         String expectedTitle = "Google";
         String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Google title verification passed");
        }else{
            System.out.println("Google title verification failed");
        }

    }
}
