package utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
public class VytrackUtils {
    private  static String userNameLocator="prependedInput";
    private  static String passwordLocator="prependedInput2";
    public static void login(WebDriver driver, String username, String password){
        driver.findElement(By.id(userNameLocator)).sendKeys(username);
        driver.findElement(By.id(passwordLocator)).sendKeys(password+ Keys.ENTER);
    }
    public  static void navigateToModule(WebDriver driver,String tab, String module){
        String tabLocatorXpath="//span[contains(text(),'"+ tab +"')and @class='title title-level-1']";
        String moduleLocatorXpath="//span[.='"+ module +"']";
        String logOutButton="a[title='Log call']";
        SeleniumUtils.pause(3);
        driver.findElement(By.xpath(tabLocatorXpath)).click();
        SeleniumUtils.pause(2);
        driver.findElement(By.xpath(moduleLocatorXpath)).click();
        SeleniumUtils.pause(1);
    }
}
