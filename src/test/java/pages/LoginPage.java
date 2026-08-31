package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");
    By loginError = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String usernameValue) {
        driver.findElement(username).sendKeys(usernameValue);
    }

    public void enterPassword(String passwordValue) {
        driver.findElement(password).sendKeys(passwordValue);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    public boolean isLoginErrorDisplayed() {
    return driver.findElement(loginError).isDisplayed();
}
}