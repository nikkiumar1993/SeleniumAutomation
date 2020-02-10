package actions;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.hoverPracticeTest.PracticeTestHover;
import utilities.Driver;

public class Practice {
   PracticeTestHover practiceTestHover = new PracticeTestHover();
   @Test
    public void hoverPractice(){
      Driver.getDriver().get("http://practice.cybertekschool.com/hovers");
       Actions actions = new Actions(Driver.getDriver());
       actions.moveToElement(practiceTestHover.firstImage).perform();
       Assert.assertTrue(practiceTestHover.firstImageAssert.isDisplayed(), "Error first text");
       actions.moveToElement(practiceTestHover.secondImage).perform();
       Assert.assertTrue(practiceTestHover.secondImageAssert.isDisplayed(), "Error second text");
       actions.moveToElement(practiceTestHover.thirdImage).perform();
       Assert.assertTrue(practiceTestHover.thirdImageAssert.isDisplayed(), "Error third text");
   }

}
