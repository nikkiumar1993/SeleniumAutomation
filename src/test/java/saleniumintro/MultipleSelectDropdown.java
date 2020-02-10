package saleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MultipleSelectDropdown {
    public static void main(String[] args)throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");


        WebElement languageDropdown = driver.findElement(By.name("Languages"));
        Select select = new Select(languageDropdown);
         List<WebElement> options = select.getOptions();
         for (WebElement option: options){
             Thread.sleep(500);
             select.selectByVisibleText(option.getText());
         }
         List<WebElement> selectOptions = select.getAllSelectedOptions();
         for (WebElement selectedOption: selectOptions){
             System.out.println(selectedOption.getText());
         }
         Thread.sleep(3000);
         select.deselectAll();

    }
}
