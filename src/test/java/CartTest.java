import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import utils.ConfigReader;

public class CartTest extends BaseTest {

    @Test
    public void verifyCartWithProduct() {

        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        productPage.addFirstProductToCart();
        productPage.openCart();

        Assert.assertTrue(
                cartPage.isCartPageDisplayed(),
                "Cart page was not displayed"
        );

        Assert.assertEquals(
                cartPage.getCartItemCount(),
                1,
                "Cart should contain one product"
        );
    }

    @Test
    public void removeProductFromCart() {

        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        productPage.addFirstProductToCart();
        productPage.openCart();

        cartPage.removeFirstProduct();

        Assert.assertEquals(
                cartPage.getCartItemCount(),
                0,
                "Product was not removed from cart"
        );
    }
}