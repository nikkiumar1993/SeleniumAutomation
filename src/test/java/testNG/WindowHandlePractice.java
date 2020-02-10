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

public class WindowHandlePractice {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        System.out.println("Instantiating the driver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/windows");
    }
    @Test
    public void titleAssert(){

        Assert.assertTrue(driver.getTitle().equals("Practice"));
        WebElement clickHereBtn = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereBtn.click();
        String mainHandle = driver.getWindowHandle();
     for (String handle: driver.getWindowHandles()){
         if(!handle.equals(mainHandle)){
             driver.switchTo().window(handle);
         }
     }
        System.out.println(driver.getTitle());
     Assert.assertEquals(driver.getTitle(), "New Window");




    }
}
