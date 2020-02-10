package saleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class DropdownPractice {
    public static void main(String[] args) {
//        TC #1: Selecting date on dropdown and verifying
//        1.Open Chrome browser
//    2.Go to http://practice.cybertekschool.com/dropdown
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        // 3.Verify “Select your date of birth” dropdowns are selected todays dateby default.
        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));
        Select selectYear = new Select(year);
        String actualYear = selectYear.getFirstSelectedOption().getText();
        String expectedYear = "2020";
        Select selectMonth = new Select(month);
        String actualMonth = selectMonth.getFirstSelectedOption().getText();
        String expectedMonth = "January";
        Select selectDay = new Select(day);
        String actualDay = selectDay.getFirstSelectedOption().getText();
        String expectedDay = "26";
        if (actualDay.equals(expectedDay) && actualMonth.equals(expectedMonth) && actualYear.equals(expectedYear)) {
            System.out.println("Todays date verification PASSED");
        } else {
            System.out.println("Todays date verification Failed");
        }
        selectYear.selectByVisibleText("1993");
        selectMonth.selectByVisibleText("August");
        selectDay.selectByVisibleText("6");
        String expectedBirthYear = "1993";
        String actualBirthYear = selectYear.getFirstSelectedOption().getText();
        String expectedBirthMonth = "August";
        String actualBirthMonth = selectMonth.getFirstSelectedOption().getText();
        String expectedBirthDay = "6";
        String actualBirthDay = selectDay.getFirstSelectedOption().getText();
        if (actualBirthDay.equals(expectedBirthDay) && actualBirthMonth.equals(expectedBirthMonth) && actualBirthYear.equals(expectedBirthYear)) {
            System.out.println("Birthday date verification PASSED");
        } else {
            System.out.println("Birthday date verification Failed");
        }



        // 4.Select “December 31st, 1921” and verify it is selected.Use all Select options.
        selectYear.selectByVisibleText("1921");
        selectMonth.selectByVisibleText("December");
        selectDay.selectByVisibleText("31");
    }
}
