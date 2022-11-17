package nl.example.steps;

import nl.example.steps.base.BaseSteps;
import io.cucumber.java.en.Given;

public class CommonSteps extends BaseSteps {

    @Given("I am on the page {string}")
    public void iAmOnThePage(String url) {
        browser.get(url);
    }

}
