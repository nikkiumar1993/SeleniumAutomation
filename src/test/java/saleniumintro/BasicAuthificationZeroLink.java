package saleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthificationZeroLink {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/login.html");
        driver.findElement(By.name("user_login")).sendKeys("username");
        driver.findElement(By.name("user_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();

        if (driver.findElement(By.linkText("username")).isDisplayed()) {
            System.out.println("username is displayed on the page verification passed");
        } else {
            System.out.println("username is displayed on the page verification failed");
        }
        String actualTitle = driver.getTitle();
        String expectedTitle = "Zero - Account Summary";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification passed");
        } else {
            System.out.println("Title verification failed");
        }
        String actualLink = driver.findElement(By.linkText("Account Summary")).getAttribute("href");
        String expectedInLink = "account-summary";
        if (actualLink.contains(expectedInLink)) {
            System.out.println("Attribute value Link verification passed");
        } else {
            System.out.println("Attribute value Link verification failed");
        }


    }
}
