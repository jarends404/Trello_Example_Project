package nl.example.pages;

import nl.example.pages.base.BasePage;

public class LoginPage extends BasePage {

    private static final String USER_NAME_FIELD = "input[id='user-name']";
    private static final String PASSWORD_FIELD = "input[id='password']";
    private static final String LOGIN_BUTTON = "input[id='login-button']";

    public void login() {
        browser.findElement(USER_NAME_FIELD).sendKeys("standard_user");
        browser.findElement(PASSWORD_FIELD).sendKeys("secret_sauce");
        browser.findElement(LOGIN_BUTTON).click();
    }
}
