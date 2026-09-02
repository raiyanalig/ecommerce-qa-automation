import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;
import utils.ConfigReader;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutWorkflow() {

        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        // Login
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        // Add product and open cart
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

        // Checkout
        checkoutPage.clickCheckout();

        checkoutPage.enterCustomerDetails(
                "Raiyan",
                "Ali",
                "144001"
        );

        checkoutPage.clickContinue();

        checkoutPage.clickFinish();

        // Verify order confirmation
        Assert.assertTrue(
                checkoutPage.isOrderConfirmed(),
                "Order confirmation was not displayed"
        );
    }
}