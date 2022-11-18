package nl.example.common.web;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import nl.example.data.base.TestData;
import nl.example.pages.base.Pages;

public class WebHook {

    private final Browser browser = Browser.getInstance();
    private final Pages pages = Pages.getInstance();
    private final TestData data = TestData.getInstance();

    @Before("@chrome or @firefox or @safari")
    public void startBrowser() {
        browser.startBrowser();
        pages.common.navigateTo("/");

        if (browser.isFirstScenario()) {
            pages.common.navigateTo("/login");
            pages.login.login(data.getAtlassianAccount().getEmailAddress(), data.getAtlassianAccount().getPassword());
            browser.waitUntilUrlContains("/boards");
            browser.storeSession();
        } else {
            browser.restoreSession();
        }
    }

    @After("@chrome or @firefox or @safari")
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = browser.makeScreenshot();
            scenario.attach(screenshot, "image/png", "name");
        }
        browser.quit();
    }

}
