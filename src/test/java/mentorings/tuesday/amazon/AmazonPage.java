package mentorings.tuesday.amazon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

public class AmazonPage {
    WebDriver driver;
    @Before
    public void setUp(){
        System.out.println("Instantiating the driver");
        WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        System.out.println("Quitting the browser");
        driver.quit();
    }

    @Test
    public void navigateTo(){

        String url = "https://www.amazon.com/";
        driver.get(url);
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.equals(url)){
            System.out.println("URL verification passed");
        }else{
            System.out.println("URL verification failed");
        }

        Assert.assertEquals(url, actualUrl);

    }






}
