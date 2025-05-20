package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CheckoutPage;
import utils.jsonReader;

public class logintest {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void loginWithValidCredentials() {
        String[] creds = jsonReader.getUserCredentials("validUser");
        loginPage.login(creds[0], creds[1]);
        Assert.assertTrue(productsPage.isOnProductsPage());
    }

    @Test
    public void loginWithInvalidCredentials() {
        String[] creds = jsonReader.getUserCredentials("invalidUser");
        loginPage.login(creds[0], creds[1]);
        Assert.assertTrue(loginPage.getErrorMessage().contains("locked out"));
    }

    @Test
    public void addToCart() {
        String[] creds = jsonReader.getUserCredentials("validUser");
        loginPage.login(creds[0], creds[1]);
        productsPage.addFirstProductToCart();
        Assert.assertEquals(productsPage.getCartCount(), "1");
    }

    @Test
    public void checkoutFlow() {
        String[] creds = jsonReader.getUserCredentials("validUser");
        loginPage.login(creds[0], creds[1]);
        productsPage.addFirstProductToCart();
        checkoutPage.goToCartAndCheckout();
        checkoutPage.fillCustomerInfo("John", "Doe", "12345");
        checkoutPage.finishCheckout();
        Assert.assertEquals(checkoutPage.getConfirmationText(), "Thank you for your order!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
