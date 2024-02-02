package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BaseTest {

    public CheckoutPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn.btn-default.check_out")
    public WebElement placeOrderButton;
    @FindBy(id = "heading")
    public WebElement ads;


    //--------------------------------

    public void clickOnPlaceOrderButton(){
        placeOrderButton.click();
    }
}
