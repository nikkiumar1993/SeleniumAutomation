package testNG;

import dynamic.SmartBearMain;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SmartBearDeleteAll {
//    TC #6: Smartbear delete all
//    1.Open browser
//        2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    // 3.Enter username: “Tester”
    // 4.Enter password: “test”
    // 5.Click to Login button
    // 6.Click to CheckAll
    // 7.Run a loop to make sure all the checkboxes are checked
    // 8.Click “Delete Selected”
    // 9.Assert “List of orders is empty. In order to add new order usethis link.“ text is displayed.
WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.out.println("Instantiating the driver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }
    @Test
    public void deleteAllTest(){

        SmartBearMain.loginToSmartBear(driver);
        WebElement checkallBtn = driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));
        checkallBtn.click();
        List<WebElement> checks = driver.findElements(By.xpath("//table[@id=‘ctl00_MainContent_orderGrid’]/tbody/tr/td[1]"));
        for (WebElement check: checks){
            Assert.assertTrue(check.isSelected());
        }
        WebElement deleteBtn = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteBtn.click();
        WebElement emptyOrdMessage = driver.findElement(By.id("ctl00_MainContent_orderMessage"));
        Assert.assertTrue(emptyOrdMessage.isDisplayed(), "Empty order list message is not displayed");
    }

}
