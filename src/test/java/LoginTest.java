import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(
                currentUrl.contains("inventory"),
                "Login was not successful"
        );
    }

    @Test
    public void invalidPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        String username = ConfigReader.getProperty("username");

        loginPage.enterUsername(username);
        loginPage.enterPassword("wrong_password");
        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.isLoginErrorDisplayed(),
                "Error message was not displayed"
        );
    }
}