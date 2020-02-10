package framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.Config;

public class SingletonTest {
    @Test
    public void test(){

        String str1 = Singleton.getWord();
        String str2 = Singleton.getWord();
        System.out.println("str: " + str1);
        System.out.println("str2: " + str2);

    }
}
