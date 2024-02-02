package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductDetailsPage extends BaseTest {

    public ProductDetailsPage(){
        PageFactory.initElements(driver, this);
    }
    CategoryProductsPage categoryProductsPage = new CategoryProductsPage();

    @FindBy(className = "product-information")
    public WebElement productInformation;

    //-----------------------------------------

    public void checkingItemsInSubcategory(String subcategory){
        for (int i = 0; i < categoryProductsPage.viewProductButtons.size(); i++) {
            driver.navigate().refresh();
            categoryProductsPage.clickOnViewProductButton(i);
            String text = productInformation.getText();
            Assert.assertTrue(text.contains(subcategory));
            driver.navigate().back();
        }
    }
}

