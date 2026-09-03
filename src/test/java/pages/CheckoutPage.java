package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;

    By checkoutButton = By.id("checkout");
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueButton = By.id("continue");
    By finishButton = By.id("finish");
    By confirmationMessage = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckout() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(
                ExpectedConditions.elementToBeClickable(checkoutButton)
        ).click();

        wait.until(
                ExpectedConditions.urlContains("checkout-step-one.html")
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstName)
        );
    }

    public void enterCustomerDetails(
            String firstNameValue,
            String lastNameValue,
            String postalCodeValue) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstName)
        ).sendKeys(firstNameValue);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(lastName)
        ).sendKeys(lastNameValue);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(postalCode)
        ).sendKeys(postalCodeValue);
    }

    public void clickContinue() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(
                ExpectedConditions.elementToBeClickable(continueButton)
        ).click();

        wait.until(
                ExpectedConditions.urlContains("checkout-step-two.html")
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(finishButton)
        );
    }

    public void clickFinish() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(
                ExpectedConditions.elementToBeClickable(finishButton)
        ).click();
    }

    public boolean isOrderConfirmed() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        confirmationMessage
                )
        ).isDisplayed();
    }
}