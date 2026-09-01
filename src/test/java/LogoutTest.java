import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

        LoginPage loginPage = new LoginPage(driver);

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        // Login
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        // Wait for products page
        wait.until(
                ExpectedConditions.urlContains("inventory.html")
        );

        // Open menu
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("react-burger-menu-btn")
                )
        ).click();

        // Wait for logout link
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("logout_sidebar_link")
                )
        );

        // Click logout using JavaScript
        JavascriptExecutor javascriptExecutor =
                (JavascriptExecutor) driver;

        javascriptExecutor.executeScript(
                "arguments[0].click();",
                driver.findElement(By.id("logout_sidebar_link"))
        );

        // Verify login page
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("login-button")
                )
        );

        Assert.assertTrue(
                driver.findElement(By.id("login-button")).isDisplayed(),
                "User was not logged out successfully"
        );
    }
}