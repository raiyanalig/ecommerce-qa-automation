import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
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

    loginPage.enterUsername("standard_user");
    loginPage.enterPassword("wrong_password");
    loginPage.clickLogin();

    Assert.assertTrue(
            loginPage.isLoginErrorDisplayed(),
            "Error message was not displayed"
    );
}
}