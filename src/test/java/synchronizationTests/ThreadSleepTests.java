package synchronizationTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.practice_cybertek_pages.DynamicLoading2page;
import utilities.Driver;

public class ThreadSleepTests {
    DynamicLoading2page dynamicLoading2page = new DynamicLoading2page();

@Test
    public void threadSleepTest() throws InterruptedException{
    Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/2");
   //Clicking to the Start button using the object we creating
    dynamicLoading2page.startButton.click();
    Thread.sleep(5000);
    //Verify text is displayed
    Assert.assertTrue(dynamicLoading2page.helloWordText.isDisplayed(), "Text is NOT displayed on the page");

}
}
