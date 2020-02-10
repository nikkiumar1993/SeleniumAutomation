package saleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumClass {
    public static void main(String[] args)throws InterruptedException {
        WebDriverManager.chromedriver().setup(); //this line creates the connection between driver and selenium. and sets up the driver

        WebDriver driver = new ChromeDriver();//instantiating the ChromeDriver instance
        driver.manage().window().maximize();

        driver.get("https://www.google.com");//whatever website you want to go to, just put it inside the driver
        System.out.println(driver.getTitle());
        driver.navigate().back();//goes back to the previous page
        //Thread.sleep(2000); waits for 2 seconds
        driver.navigate().forward();//goes to the next page
        //Thread.sleep(2000);

        driver.navigate().refresh();//refreshes the page
        //Thread.sleep(2000);
        driver.navigate().to("https://www.etsy.com");
        System.out.println(driver.getTitle());
        driver.close();//closes the page



    }
}
