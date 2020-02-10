package saleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBoxesPractice {
    public static void main(String[] args) {
//        Practice:	Cybertek	Checkboxes
//        1.Go	to	http://practice.cybertekschool.com/checkboxe
         WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");
//        2.Confirm	checkbox #1	is	NOT	selected	by	default
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        if(checkBox1.isSelected()){
            System.out.println("Check box 1 is selected. Verification Failed");
        }else{
            System.out.println("Check box 1 is not selected. Verification PASSED");
        }
//        3.Confirm	checkbox #2	is	SELECTED	by	default.
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        if(checkbox2.isSelected()){
            System.out.println("Check box 2 is selected. Verification PASSED");
        }else {
            System.out.println("Check box 2 is not selected. Verification FAILED");
        }
//        4.Click	checkbox	#1	to	select	it.
        checkBox1.click();
//        5.Click	checkbox	#2	to	deselect	it.
        checkbox2.click();
//        6.Confirm	checkbox	#1	is	SELECTED.
        if(checkBox1.isSelected()){
            System.out.println("Check box 1 is selected. Verification Passed");
        }else{
            System.out.println("Check box 1 is not selected. Verification FAILED");
        }
//        7.Confirm	checkbox	#2	is	NOT
        if(!checkbox2.isSelected()){
            System.out.println("Check box 2 is not selected. Verification PASSED");
        }else {
            System.out.println("Check box 2 is selected. Verification FAILED");
        }
    }
}
