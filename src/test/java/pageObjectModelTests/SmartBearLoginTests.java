package pageObjectModelTests;


import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.smartbear_pages.LoginPage;
import utilities.Config;
import utilities.Driver;

import java.util.Properties;

public class SmartBearLoginTests {

    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(Config.getProperty("smartbearUrl"));
    }

    @Test
    public void wrongUserNameTest() {


        //1we get the page

        //2we enter wrong username
        String wrongUsername = Config.getProperty("wrongUsername");
        loginPage.usernameInput.sendKeys(wrongUsername);
        //3we enter correct password
        loginPage.passwordInput.sendKeys(Config.getProperty("correctPassword"));
        //4click login button
        loginPage.loginButton.click();
        //5verify error message
        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is not displayed");


    }

    @Test
    public void wrongPassword() {
        loginPage.usernameInput.sendKeys("correctUsername");
        loginPage.passwordInput.sendKeys("wrongPassword");
        loginPage.loginButton.click();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is not displayed");
    }

    @Test
    public void emptyUsername() {
        loginPage.usernameInput.sendKeys("");
        loginPage.passwordInput.sendKeys("correctPassword");
        loginPage.loginButton.click();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is not displayed");
    }

    @Test
    public void emptyPassword() {

        loginPage.usernameInput.sendKeys("correctUsername");
        loginPage.passwordInput.sendKeys("");
        loginPage.loginButton.click();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is not displayed");

    }


}
