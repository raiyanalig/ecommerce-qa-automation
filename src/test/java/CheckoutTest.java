import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;

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

        // Add product
        productPage.addFirstProductToCart();

        // Open cart
        productPage.openCart();

        // Verify product is in cart
        Assert.assertEquals(
                cartPage.getCartItemCount(),
                1,
                "Cart should contain one product"
        );

        // Start checkout
        checkoutPage.clickCheckout();

        // Enter customer details
        checkoutPage.enterCustomerDetails(
                "Raiyan",
                "Ali",
                "144001"
        );

        // Continue to order overview
        checkoutPage.clickContinue();

        // Finish order
        checkoutPage.clickFinish();

        // Verify order confirmation
        Assert.assertTrue(
                checkoutPage.isOrderConfirmed(),
                "Order confirmation was not displayed"
        );
    }
}