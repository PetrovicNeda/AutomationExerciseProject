package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ProductsPage extends BaseTest {

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

    CartPage cartPage = new CartPage();

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
    @FindBy(css = ".badge.pull-right")
    public List<WebElement> category;
    @FindBy(css = "a[href='/category_products/1'")
    public WebElement dressSubcategoryButton;
    @FindBy(css = "a[href='/category_products/2'")
    public WebElement topsSubcategoryButton;
    @FindBy(css = "a[href='/category_products/3'")

    public WebElement tshirtsSubcategoryButton;
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
    public void addItemToCartAndOpetCart(){
        scrollToElement(poloButton);
        clickOnAddToCartButton(0);
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.close-modal.btn-block")));
        Assert.assertTrue(continueShoppingButton.isDisplayed());

        clickOnViewCartButton();
        Assert.assertTrue(cartPage.products.get(0).isDisplayed());
    }
    public void clickOnCategory(int j){
            category.get(j).click();
    }
    public void clickOnDressSubcategoryButton(){
        dressSubcategoryButton.click();
    }
    public void clickOnTopsSubcategoryButton(){
        topsSubcategoryButton.click();
    }
    public void clickOnTShirtsSubcategoryButton(){
        tshirtsSubcategoryButton.click();
    }

}