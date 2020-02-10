package saleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBoxPractice3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        WebElement checkAllButtons = driver.findElement(By.xpath("//input[@id='check1']"));
        String expectedCheckAllText = "Check All";
        String actualText = checkAllButtons.getAttribute("value");
        if (expectedCheckAllText.equals(actualText)) {
            System.out.println("Check box text verification PASSED ");
        } else {
            System.out.println("Check box text verification FAILED ");
        }
        checkAllButtons.click();
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@class='cb1-element'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@class='cb1-element'])[2]"));
        WebElement checkbox3 = driver.findElement(By.xpath("(//input[@class='cb1-element'])[3]"));
        WebElement checkbox4 = driver.findElement(By.xpath("(//input[@class='cb1-element'])[4]"));
        if(checkbox1.isSelected() && checkbox2.isSelected() && checkbox3.isSelected() && checkbox4.isSelected()){
            System.out.println("All checkboxes checked verification PASSED");
        }else {
            System.out.println("All checkboxes checked verification FAILED");
        }

        String expectedValueAfterClick = "Uncheck All";
        String actualValueAfterCheck = checkAllButtons.getAttribute("value");
        if(expectedValueAfterClick.equals(actualValueAfterCheck)){
            System.out.println("Uncheck All text verification PASSED");
        }else {
            System.out.println("Uncheck All text verification FAILED");
        }

    }
}
