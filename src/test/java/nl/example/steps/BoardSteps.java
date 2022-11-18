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
import nl.example.testers.CardTester;

import java.net.MalformedURLException;

public class BoardSteps extends BaseSteps {

    private final BoardTester boardTester = new BoardTester();
    private final CardTester cardTester = new CardTester();
    private final Board board = getData().getBoard();
    private final Card card = getData().getCard();

    @After("@deleteBoardAfter")
    public void deleteBoard() {
        boardTester.closeBoard();
        boardTester.deleteBoard();
    }

    @Given("I create a new board")
    public void iCreateANewBoard() {
        boardTester.createBoard(board);
    }

    @When("I visit my board")
    public void iVisitMyBoard() throws MalformedURLException {
        String uri = boardTester.getBoardUri(board);
        getPages().common.navigateTo(uri);
    }

    @When("I move the card to the {string} list")
    public void iMoveTheCardToTheList(String list) {
        System.out.println("");
    }

    @Then("my created board is visible")
    public void myCreatedBoardIsVisible() {
        getPages().board.verifyDefaultElementsVisible(board);
    }

    @And("I create a new card in the {string} list")
    public void iCreateANewCardInTheList(String list) {
        getPages().board.addCard(list, card.getName());
    }

    @And("add a card to the {string} list")
    public void addACardToTheList(String list) {
        String listId = boardTester.getListId(list);
        cardTester.createCard(card, listId);
    }

    @Then("my created card is visible")
    public void myCreatedCardIsVisible() {
        getPages().board.verifyCardInList(card.getName());
    }

    @Then("the card is displayed in the {string} list")
    public void theCardIsDisplayedInTheList(String list) {

    }
}
