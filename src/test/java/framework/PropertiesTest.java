package framework;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Config;
import utilities.VytrackUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PropertiesTest {
    @Test
    public void test1() throws IOException {
        //Create the path of the file
        String path = "test.properties";

       // Properties object
        Properties properties = new Properties();
        //Open the file using FileInputStream
        FileInputStream file = new FileInputStream(path);
        //Load the properties file into the properties object
        properties.load(file);
        //Read the values using getProperty () method
        System.out.println(properties.getProperty("name"));
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));
    }
    @Test
    public void testWithUtil(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(Config.getProperty("vytrackUrl"));
        VytrackUtils.login(driver,Config.getProperty("storemanagerUsername"),Config.getProperty("storemanagerPassword"));
    }
}
