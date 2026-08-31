package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    By cartTitle = By.className("title");
    By cartItems = By.className("cart_item");
    By removeButton = By.cssSelector(".cart_item button");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCartPageDisplayed() {
        return driver.findElement(cartTitle).isDisplayed();
    }

    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }

    public void removeFirstProduct() {
        driver.findElement(removeButton).click();
    }
}