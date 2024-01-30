package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage extends BaseTest {

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "single-products")
    public List<WebElement> products;
    @FindBy(css = "a[href='/brand_products/Polo'")
    public WebElement poloButton;

    @FindBy(linkText = "Add to cart")
    public List<WebElement> addToCartButton;

    @FindBy(css = ".btn.btn-success.close-modal.btn-block")

    public WebElement continueShoppingButton;

//-------------------------------------------

    public void hoverOverFirstProduct() {
        Actions actions = new Actions(driver);
        actions.moveToElement(products.get(0)).build().perform();
    }

    public void clickOnFirstAddToCartButton(){
        addToCartButton.get(1).click();
    }
}