package saleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.jar.JarOutputStream;

public class BackAndForthNavigation {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        driver.findElement(By.linkText("Gmail")).click();

        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Gmail title passed");
        } else {
            System.out.println("Gmail title failed");
        }

        driver.navigate().back();
        String expectedBackTitle = "Google";
        String actualBackTitle = driver.getTitle();

        if (actualBackTitle.contains(expectedBackTitle)) {
            System.out.println("Back to Google title passed");
        } else {
            System.out.println("Back to Google title failed");
        }

            driver.navigate().forward();
            String expectedForwardTitle = "Gmail";
            String actualForwardTitle = driver.getTitle();

            if (actualForwardTitle.contains(expectedForwardTitle)){
                System.out.println("Forward to Gmail title passed");
            } else {
                System.out.println("Forward to Gmail title failed");
            }

        }
    }

