package saleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;

public class ReviewTxt {

        public static void main(String[] args) throws Exception{
//            File file = new File("/Users/nikkiumarova/Desktop/First test file.txt");
//            Scanner scanner = new Scanner(file);
//            while (scanner.hasNextLine()){
//                System.out.println(scanner.nextLine());
//            }
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream("review.properties");
            properties.load(file);
            String s = properties.getProperty("day");
            System.out.println(s);
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://google.com/");
            driver.findElement(By.name("q")).sendKeys(properties.getProperty("item") + Keys.ENTER);
            System.out.println(driver.getTitle());
            driver.quit();

        }
    }

