package nl.example.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nl.example.data.dto.Board;
import nl.example.data.dto.Card;
import nl.example.steps.base.BaseSteps;
import nl.example.testers.BoardTester;

import java.net.MalformedURLException;

public class BoardSteps extends BaseSteps {

    private final BoardTester tester = new BoardTester();
    private final Board board = getData().getBoard();
    private final Card card = getData().getCard();

    @After("@deleteBoardAfter")
    public void deleteBoard() {
        tester.closeBoard();
        tester.deleteBoard();
    }

    @Given("I create a new board")
    public void iCreateANewBoard() {
        tester.createBoard(board);
    }

    @When("I visit my board")
    public void iVisitMyBoard() throws MalformedURLException {
        String uri = tester.getBoardUri(board);
        getPages().common.navigateTo(uri);
    }

    @Then("my created board is visible")
    public void myCreatedBoardIsVisible() {
        getPages().board.verifyDefaultElementsVisible(board);
    }

    @And("I create a new card in the {string} list")
    public void iCreateANewCardInTheList(String list) {
        getPages().board.addCard(list, card.getTitle());
    }

    @Then("my created card is visible")
    public void myCreatedCardIsVisible() {
        getPages().board.verifyCardInList(card.getTitle());
    }
}
