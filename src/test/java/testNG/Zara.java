package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Zara {
    WebDriver driver;
    @BeforeClass
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.zara.com/us/");
    }
    @Test
    public void womanTest(){


        WebElement dropDown = driver.findElement(By.xpath("//div[@class='menu-icon _menu-icon']"));
        dropDown.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement womenBtn = driver.findElement(By.xpath("(//span[.='WOMAN'])[2]"));
      womenBtn.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      WebElement saleBtn = driver.findElement(By.xpath("(//span[.='SALE'])[1]"));
      saleBtn.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      WebElement shoesSale = driver.findElement(By.xpath("(//span[.='SHOES'])[2]"));
      shoesSale.click();
  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    WebElement filter = driver.findElement(By.xpath("//div[.='Filters']"));
    filter.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement six6 = driver.findElement(By.xpath("//div[@data-value='7000000000000000007']"));
        six6.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement colorBlack = driver.findElement(By.xpath("//div[@data-value='15']"));
        colorBlack.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement ankleBoots = driver.findElement(By.xpath("//div[@data-value='7000000000000122001']"));
        ankleBoots.click();
//        WebElement shoes = driver.findElement(By.xpath("//div[@data-value='7000000000000001566']"));
//        shoes.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement meshAnkleBoots = driver.findElement(By.xpath("//a[.='MESH ANKLE BOOTS']"));
        meshAnkleBoots.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement size6 = driver.findElement(By.xpath("(//div[@title='6'])[1]"));
        size6.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement addBtn = driver.findElement(By.xpath("(//button[.='Add'])[1]"));
        addBtn.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement completeOrder = driver.findElement(By.xpath("//a[@style='display: inline-block;']"));
        completeOrder.click();



    }

}
