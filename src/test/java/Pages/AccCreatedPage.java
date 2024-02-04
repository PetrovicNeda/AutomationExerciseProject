package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccCreatedPage extends BaseTest {

    public AccCreatedPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText = "Continue")
    public WebElement continueButton;
    @FindBy(css = ".title.text-center")
    public WebElement message;
}
