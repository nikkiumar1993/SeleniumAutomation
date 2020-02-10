package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertClass {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        System.out.println("Instantiating the driver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }
    @Test
    public void alertJS(){
        WebElement clickForJSAlert = driver.findElement(By.xpath("//button[@class='btn btn-primary'][1]"));
        clickForJSAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You successfuly clicked an alert", "Texts are not matching. Assertion Failed");
    }
    @Test
    public void confirmJS(){
        WebElement clickForJSConfirm = driver.findElement(By.xpath("//button[@class='btn btn-primary'][2]"));
        clickForJSConfirm.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Ok", "Texts are not matching. Confirmation Failed");
    }
    @Test
    public void promptJS(){
        WebElement clickForJSPrompt = driver.findElement(By.xpath("//button[@class='btn btn-primary'][3]"));
        clickForJSPrompt.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello world");
        alert.accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: hello world", "Texts are not matching. Prompt Failed");

    }

}
