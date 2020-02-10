package saleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearLiknVerif {



    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        WebElement username= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        password.sendKeys("test");
        WebElement submitBut = driver.findElement(By.xpath("//input[@type='submit']"));
        submitBut.click();
         List<WebElement> links = driver.findElements(By.xpath("//body//a"));
        System.out.println(links.size());
        for (WebElement link:links){
            System.out.println(link.getText());
        }
        loginToSmartBear(driver);




    }
    public static void loginToSmartBear(WebDriver driver){
        WebElement inputUsername = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement inputPassword = driver.findElement(By.id("ctl00_MainContent_password"));
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        inputUsername.sendKeys("Tester");
        inputPassword.sendKeys("test");
        loginButton.click();
    }


}
