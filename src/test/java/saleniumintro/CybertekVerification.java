package saleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CybertekVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cybertekschool.com");
        String expectedUrl = "https://cybertekschool.com";
        String actualUrl = driver.getCurrentUrl();
      String expectedTitle = "Cybertek";
      String actualTitle = driver.getTitle();
      if(expectedUrl.contains(actualUrl)){
          System.out.println("Cybertek URL passed");
      }else{
          System.out.println("Cybertek URL failed");
      }
      if(expectedTitle.equals(actualTitle)){
          System.out.println("Cybertek title passed");
      }else{
          System.out.println("Cybertek title failed");
      }

    }
}
