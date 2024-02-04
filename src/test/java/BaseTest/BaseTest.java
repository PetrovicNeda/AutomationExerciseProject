package BaseTest;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

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
    public DeleteAccPage deleteAccPage;
    public ExcelReader excelReader;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void before() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        homePage = new HomePage();
        homePage.clickOnLoginSignupButton();
        loginPage = new LoginPage();
        excelReader = new ExcelReader("TestData.xlsx");
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickOnElementAndCloseVignette(WebElement elementToClick) {
        elementToClick.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("const elements = document.getElementsByClassName" +
                "('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
        elementToClick.click();
    }

    public void closeVignette() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("const elements = document.getElementsByClassName" +
                "('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
