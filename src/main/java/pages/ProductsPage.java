package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    By title = By.className("title");
    By addToCartButton = By.cssSelector(".inventory_item:first-of-type button");
    By cartIcon = By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOnProductsPage() {
        return driver.findElement(title).getText().equals("Products");
    }

    public void addFirstProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    public String getCartCount() {
        return driver.findElement(cartIcon).getText();
    }
}
