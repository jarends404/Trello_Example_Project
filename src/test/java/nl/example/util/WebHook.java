package nl.example.util;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WebHook {

    private final Browser browser = Browser.getInstance();

    @Before
    public void beforeScenario() {
        browser.startBrowser();
    }

    @After
    public void afterScenario(Scenario scenario) {
        browser.quit();
        if (scenario.isFailed()) {
            byte[] screenshot = browser.makeScreenshot();
            scenario.attach(screenshot, "image/png", "name");
        }
    }

}
