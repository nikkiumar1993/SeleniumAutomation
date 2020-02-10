package testNG;


import org.testng.Assert;
import org.testng.annotations.*;

public class FirstTestNGClass {

    @Test
    public void afirstTest() {
        System.out.println("1st test is running...");
//        if("q".equals("q")){
//            System.out.println("PASS!");
//        }else{
//            System.out.println("Fail");
//        }
        Assert.assertEquals("actualValue", "actualValue", "Test has failed");
        Assert.assertEquals(1, 1, "message");
    }

    @Test
    public void bsecondTest() {
        System.out.println("2nd test is running");
        String letter = "e";
        Assert.assertTrue("sentence".contains(letter), "Sentence does not contain given letter!!!" + letter);
    }

    @BeforeClass
    public void setUp() {
        System.out.println("Before class is running");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method is running...");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method is running...");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("After class is running");
    }

}
