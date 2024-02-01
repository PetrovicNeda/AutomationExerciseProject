package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends BaseTest {

    public ProductDetailsPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(tagName = "p")
    public WebElement dressCategory;
}
