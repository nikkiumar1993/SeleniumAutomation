package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframePractice {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        System.out.println("Instantiating the driver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/iframe");
    }
    @Test
    public void iframeTest(){
        driver.switchTo().frame(0);

        WebElement par = driver.findElement(By.xpath("//body[.='Your content goes here.']"));
        Assert.assertTrue(par.isDisplayed());
        driver.switchTo().parentFrame();
        WebElement header = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(header.isDisplayed());
    }

}
