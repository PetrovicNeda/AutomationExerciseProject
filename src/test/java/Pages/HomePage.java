package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href='/login'")
    public WebElement loginSignupButton;

    @FindBy(css = "a[href='/logout'")
    public WebElement logoutButton;

    @FindBy(css = "a[href='/products'")
    public WebElement productsButton;


    //-----------------------------

    public void clickOnLoginSignupButton() {
        loginSignupButton.click();
    }
    public void clickOnLogoutButton(){
        logoutButton.click();
    }
    public void clickOnProductsButton(){
        productsButton.click();
    }

}
