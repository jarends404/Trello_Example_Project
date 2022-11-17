package nl.example.steps;

import nl.example.steps.base.BaseSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseSteps {

    @When("I enter valid credentials")
    public void iEnterValidCredentials() {
        pages.login.login();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        pages.inventory.isAt();
    }
}
