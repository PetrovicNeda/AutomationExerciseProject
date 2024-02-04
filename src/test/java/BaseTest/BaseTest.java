package BaseTest;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public static WebDriver driver;
    public HomePage homePage;
    public LoginPage loginPage;
    public RegistrationPage registrationPage;
    public ProductsPage productsPage;
    public WebDriverWait wait;
    public CartPage cartPage;
    public AccCreatedPage accCreatedPage;
    public CategoryProductsPage categoryProductsPage;
    public ProductDetailsPage productDetailsPage;
    public CheckoutPage checkoutPage;
    public PaymentPage paymentPage;
    public ContactFormPage contactFormPage;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();

    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void closeVignette(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("const elements = document.getElementsByClassName" +
                "('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
    }
}
