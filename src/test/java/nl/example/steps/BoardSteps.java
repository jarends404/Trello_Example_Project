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

    @Given("a new board is displayed")
    public void iCreateANewBoard() throws MalformedURLException {
        boardTester.createBoard(board);
        String uri = boardTester.getBoardUri(board);
        getPages().common.navigateTo(uri);
    }

    @When("the user moves the card to the {string} list")
    public void iMoveTheCardFromTheListToTheList(String listTo) {
        getPages().board.openCardDetails(card.getName());
        getPages().card.moveCardToList(listTo);
    }

    @Then("the created board's default elements are visible")
    public void myCreatedBoardIsVisible() {
        getPages().board.verifyDefaultElementsVisible(board);
    }

    @And("the user creates a new card in the {string} list")
    public void iCreateANewCardInTheList(String list) {
        getPages().board.addCard(list, card.getName());
    }

    @And("there is a card in the {string} list")
    public void addACardToTheList(String list) {
        String listId = boardTester.getListId(list);
        cardTester.createCard(card, listId);
    }

    @Then("the card is displayed in the {string} list")
    public void theCardIsDisplayedInTheList(String list) {
        getPages().board.verifyCardInList(card.getName(), list);
    }
}
