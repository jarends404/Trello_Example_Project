package nl.example.pages;

import nl.example.pages.base.BasePage;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private static final String EMAIL_FIELD = "input[id='user']";
    private static final String PASSWORD_FIELD = "input[id='password']";
    private static final String CONTINUE_BUTTON = "input[id='login']";
    private static final String LOGIN_BUTTON = "button[id='login-submit']";

    public void login(final String email, final String password) {
        emailField().sendKeys(email);
        continueButton().click();
        passwordField().sendKeys(password);
        loginButton().click();
    }

    private WebElement emailField() {
        getBrowser().waitUntilUrlContains("/login");
        return getBrowser().findElement(EMAIL_FIELD);
    }

    private WebElement continueButton() {
        return getBrowser().findElement(CONTINUE_BUTTON);
    }

    private WebElement passwordField() {
        getBrowser().waitUntilUrlContains("/login?application=trello&continue");
        return getBrowser().findElement(PASSWORD_FIELD);
    }


    private WebElement loginButton() {
        return getBrowser().findElement(LOGIN_BUTTON);
    }
}
