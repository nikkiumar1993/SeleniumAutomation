package saleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Amazonpractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://www.amazon.com");
        WebElement dropdownAll = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdownAll);
        select.selectByVisibleText("Alexa Skills");
       WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
       search.sendKeys("iphone" + Keys.ENTER);
       driver.manage().timeouts();
       int []intArray = new int[2];
       intArray[1] =1;

    }
}
