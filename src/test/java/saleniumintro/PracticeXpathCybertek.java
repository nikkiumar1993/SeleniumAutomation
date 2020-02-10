package saleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeXpathCybertek {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement homeLink = driver.findElement(By.xpath("//a[.='Home']"));
        WebElement forgotPasswordHeader = driver.findElement(By.xpath("//div[@class='example']/h2"));
        WebElement emailLabel = driver.findElement(By.xpath("//label[@for='email']"));
        WebElement inputBox = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement retrievePasswordButton = driver.findElement(By.xpath("//button[@id='form_submit']"));
        WebElement poweredByCybertekSchool = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        if(homeLink.isDisplayed() && forgotPasswordHeader.isDisplayed() && emailLabel.isDisplayed() && inputBox.isDisplayed() && retrievePasswordButton.isDisplayed() && poweredByCybertekSchool.isDisplayed()){
            System.out.println("All web elements are displayed");
        }else{
            System.out.println("One or more are not displayed");
        }


    }
}
