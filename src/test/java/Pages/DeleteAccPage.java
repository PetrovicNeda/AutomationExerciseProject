package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccPage extends BaseTest {
    public DeleteAccPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".title.text-center")
    public WebElement deleteMessage;
}
