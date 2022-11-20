package nl.example.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nl.example.data.dto.Card;
import nl.example.steps.base.BaseSteps;

public class CardSteps extends BaseSteps {

    private final Card card = getData().getCard();

    @When("the user adds a label to the card")
    public void theUserAddsALabelToTheCard() {
        getPages().board.openCardDetails(card.getName());
        getPages().card.addLabel("test-label");
    }

    @Then("the label is displayed")
    public void theLabelIsDisplayed() {
        getPages().card.verifyLabelVisible("test-label");
    }
}
