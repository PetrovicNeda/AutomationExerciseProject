package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage extends BaseTest {

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href='/brand_products/Polo'")
    public WebElement poloButton;
    @FindBy(linkText = "Add to cart")
    public List<WebElement> addToCartButton;
    @FindBy(css = ".btn.btn-success.close-modal.btn-block")
    public WebElement continueShoppingButton;
    @FindBy(linkText = "View Cart")
    public WebElement viewCartButton;
    @FindBy(css = "a[href='/view_cart']")
    public WebElement cartButton;

//-------------------------------------------


    public void clickOnAddToCartButton(int i){
        addToCartButton.get(i).click();
    }

    public void clickOnViewCartButton(){
        viewCartButton.click();
    }
    public void clickOnContinueShoppingButton(){
        continueShoppingButton.click();
    }
    public void clickOnCartButton(){
        cartButton.click();
    }


}