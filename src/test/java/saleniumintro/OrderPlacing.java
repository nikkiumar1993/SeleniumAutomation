package saleniumintro;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class OrderPlacing {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        WebElement username = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        password.sendKeys("test");
        WebElement submitBut = driver.findElement(By.xpath("//input[@type='submit']"));
        submitBut.click();
        WebElement order = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        order.click();
        WebElement product = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select productFamily = new Select(product);
        productFamily.selectByVisibleText("FamilyAlbum");
        WebElement quantity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantity.sendKeys(Keys.BACK_SPACE + "2");
        WebElement calc = driver.findElement(By.xpath("//input[@type='submit']"));
        calc.click();
        Faker faker = new Faker();
        WebElement custName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        custName.sendKeys(faker.name().fullName());
        WebElement street = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
        street.sendKeys(faker.address().streetAddress());
        WebElement city = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']"));
        city.sendKeys(faker.address().city());
        WebElement state = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']"));
        WebElement zip = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));
        state.sendKeys(faker.address().state());
        zip.sendKeys(faker.address().zipCode().substring(0, 5));
        WebElement visa = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
        visa.click();
        WebElement cardNum = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']"));
        cardNum.sendKeys(faker.finance().creditCard().replaceAll("-", ""));


        WebElement expDate = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']"));
        expDate.sendKeys("08/06");
        WebElement process = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        process.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[@class ='buttons_process']/strong"));

        String expectedMessage = "New order has been successfully added.";
        if(successMessage.isDisplayed()){
            System.out.println("Message Verification Passed ");
        }else{
            System.out.println("Message Verification Failed");
        }


    }
}
