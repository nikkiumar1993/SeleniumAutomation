package actions;


import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.amazonPages.AmazonLandingPage;
import utilities.Driver;

public class AmazonTests {

    AmazonLandingPage amazonLandingPage = new AmazonLandingPage();
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://www.amazon.com");
    }

    @Test
    public void signInLinkHoverTest(){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(amazonLandingPage.signinLink).perform();


    }

}
