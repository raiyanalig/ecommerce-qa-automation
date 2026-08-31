package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver driver;

    By productsTitle = By.className("title");
    By firstProduct = By.className("inventory_item");
    By cartIcon = By.className("shopping_cart_link");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductsPageDisplayed() {
        return driver.findElement(productsTitle).isDisplayed();
    }

    public void addFirstProductToCart() {
        driver.findElement(firstProduct)
                .findElement(By.tagName("button"))
                .click();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }
}