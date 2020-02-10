package synchronizationTests;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.practice_cybertek_pages.DynamicLoading1Page;
import utilities.Driver;

public class ExplicitWaitTests {
    DynamicLoading1Page dynamicLoading1Page = new DynamicLoading1Page();

    @Test
    public void waitForInputBoxTest(){
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");
        dynamicLoading1Page.startButton.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(dynamicLoading1Page.usernameInput));
        dynamicLoading1Page.usernameInput.sendKeys("tomsmith");
        dynamicLoading1Page.passwordInput.sendKeys("SuperSecretPassword");
        dynamicLoading1Page.submitButton.click();

    }
}
