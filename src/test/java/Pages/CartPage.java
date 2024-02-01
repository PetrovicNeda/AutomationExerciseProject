package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BaseTest {

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "cart_product")
    public List<WebElement> products;
    @FindBy(className = "cart_quantity_delete")
    public List<WebElement> deleteButton;
    @FindBy(className = "cart_quantity")
    public WebElement cartQuantity;
    @FindBy(id = "empty_cart")
    public WebElement emptyCart;

    //-------------------------------

    public void clickOnDeleteButton(int i) {
        deleteButton.get(i).click();
    }

}
