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
import java.util.concurrent.TimeUnit;

public class SmartBearTests {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.out.println("Instantiating the driver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearMain.loginToSmartBear(driver);
    }
    @Test
    public void deleteOrderTest(){

        WebElement markSmithCheckbox = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[.='Mark Smith']/../td[1]"));
        markSmithCheckbox.click();
        WebElement deleteBtn = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteBtn.click();
        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
        for (WebElement name: allNames){
            System.out.println(name.getText());
            Assert.assertFalse(name.getText().equals("Mark Smith"), "The name is on the list. Test Failed");
        }
    }

    @Test
    public void editName(){
        WebElement editSteveJohns = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[.='Steve Johns']/../td[13]"));
        editSteveJohns.click();
        WebElement customerName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        customerName.clear();
        customerName.sendKeys("Michael Jordan");
        WebElement updateBtn = driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton"));
        updateBtn.click();
        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
        for (WebElement name: allNames) {
            System.out.println(name.getText());
            if (name.getText().equals("Michael Jordan")) {
                Assert.assertTrue(name.getText().equals("Michael Jordan"), "The name is on the list. Test Failed");
            }
        }

    }

    @Test
    public void deleteNameTest2(){
        deleteName(driver, "Bob Feather");
    }
    public static void deleteName(WebDriver driver, String nameToBeDeleted){
        String word = "example";
        String sentence = "This is " + word + " my sentence";

        String xpathForCheckbox = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[.='"+nameToBeDeleted+"']/../td[1]";

        WebElement markSmithCheckbox = driver.findElement(By.xpath(xpathForCheckbox));
        markSmithCheckbox.click();
        WebElement deleteBtn = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteBtn.click();
        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
        for (WebElement name: allNames){
            System.out.println(name.getText());
            Assert.assertFalse(name.getText().equals(nameToBeDeleted), "The name is on the list. Test Failed");
        }

    }
}
