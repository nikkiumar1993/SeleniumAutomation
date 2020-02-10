package saleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LinksOnPage {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.openxcell.com");
        List<WebElement> LinksOnThePage = new ArrayList<WebElement>(driver.findElements(By.xpath("//body//a")));
       int actualNUmberOfLinks =  LinksOnThePage.size();
       int expectedNumberOfLinks = 188;
       if(expectedNumberOfLinks==actualNUmberOfLinks){
           System.out.println("Link size verification PASSED");
       }else {
           System.out.println("Link size verification PASSED");
       }

        int count=0;
       for (WebElement link: LinksOnThePage){
           System.out.println(link.getText());
           if(link.getText().equals("")){
               count++;
           }
       }
       int expectedEmptyLinks = 109;
       int actualNumOfEmptyLinks = count;
       if (expectedEmptyLinks==actualNumOfEmptyLinks){
           System.out.println("Links without text verification Passed");
       }else {
           System.out.println("Links without text verification Failed");
       }




    }
}
