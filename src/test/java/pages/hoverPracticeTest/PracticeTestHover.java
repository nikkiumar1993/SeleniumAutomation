package pages.hoverPracticeTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PracticeTestHover {
    public PracticeTestHover(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//img[@alt='User Avatar'])[1]")
    public WebElement firstImage;
    @FindBy(xpath = "(//h5)[1]")
    public WebElement firstImageAssert;
    @FindBy(xpath = "(//img[@alt='User Avatar'])[2]")
    public WebElement secondImage;
    @FindBy(xpath = "(//h5)[2]")
    public WebElement secondImageAssert;
    @FindBy(xpath = "(//img[@alt='User Avatar'])[3]")
    public WebElement thirdImage;
    @FindBy(xpath = "(//h5)[3]")
    public WebElement thirdImageAssert;
}
