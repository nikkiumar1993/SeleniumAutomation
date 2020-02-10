package dynamic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class VerifyOrder {
    public void verifyOrder(WebDriver driver, String givenName){
List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
for(WebElement name: allNames){
    if (name.getText().equals(givenName)){
        System.out.println(givenName + " exists in the list. Verification PASSED");

        return;
    }
}
        System.out.println(givenName + " doesn't exist in the list. Verification failed");
    }

    public void printNamesAndCities(WebDriver driver){
        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));

        List<WebElement> allCities = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[7]"));
//        for (WebElement city: allCities){
//            System.out.println(city.getText());
//        }
        for (int i = 0; i <allCities.size() ; i++) {
            System.out.println("Name: " + allNames.get(i).getText() + " City: " + allCities.get(i).getText());
        }


    }


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
        VerifyOrder order1 = new VerifyOrder();
        order1.printNamesAndCities(driver);




    }
}
