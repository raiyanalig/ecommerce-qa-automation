import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

        LoginPage loginPage = new LoginPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Login
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Wait for inventory page
        wait.until(
                ExpectedConditions.urlContains("inventory.html")
        );

        // Open menu
        WebElement menuButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("react-burger-menu-btn")
                )
        );

        menuButton.click();

        // Wait until logout option is visible
        WebElement logoutLink = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("logout_sidebar_link")
                )
        );

        // Click logout
        logoutLink.click();

        // Verify redirection to login page
        wait.until(
                ExpectedConditions.urlToBe("https://www.saucedemo.com/")
        );

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.saucedemo.com/",
                "User was not logged out successfully"
        );
    }
}