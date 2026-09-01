import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductPage;

public class ProductTest extends BaseTest {

    @Test
    public void verifyProductsPage() {

        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        Assert.assertTrue(
                productPage.isProductsPageDisplayed(),
                "Products page was not displayed"
        );
    }

    @Test
    public void addFirstProductToCart() {

        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        productPage.addFirstProductToCart();

        Assert.assertTrue(
                driver.findElement(
                        org.openqa.selenium.By.className("shopping_cart_badge")
                ).isDisplayed(),
                "Product was not added to cart"
        );
    }
}