package saleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class PracticeDropdowns {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement stateDropdown = driver.findElement(By.id("state"));
        Select select = new Select(stateDropdown);
        String text = select.getFirstSelectedOption().getText();
        System.out.println(text);
        Thread.sleep(1000);
        select.selectByVisibleText("California");
        Thread.sleep(1000);
        select.selectByIndex(12);;
        Thread.sleep(1000);
        select.selectByValue("FL");
        String expectedOption = "Florida";
        String actualOption = select.getFirstSelectedOption().getText();
        if (expectedOption.equals(actualOption)){
            System.out.println("Final result is Florida. Verification PASSED");
        }else {
            System.out.println("Final result is Florida. Verification Failed");
        }

    }
}
