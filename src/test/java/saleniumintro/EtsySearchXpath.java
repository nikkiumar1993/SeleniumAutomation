package saleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsySearchXpath {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com");
        WebElement wb = driver.findElement(By.xpath("//*[@id=\"global-enhancements-search-query\"]"));
        wb.sendKeys("wooden spoon");
        driver.findElement(By.xpath("//*[@id=\"gnav-search\"]/div/div[1]/button")).click();

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[3]/div[2]/div[2]/div/ul/li[1]/div/a/div[1]/div/div[1]/div/div/div/img")).click();
    driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--filled wt-width-full wt-mt-xs-2']")).click();
    }
}
