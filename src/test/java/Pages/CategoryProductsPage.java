package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CategoryProductsPage extends BaseTest {
    public CategoryProductsPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".nav.nav-pills.nav-justified")
    public List<WebElement> viewProductButtons;

    //---------------------------------

    public void clickOnViewProductButton(int i){
        viewProductButtons.get(i).click();
    }
}
