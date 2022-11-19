package nl.example.pages;

import io.cucumber.core.exception.CucumberException;
import nl.example.data.dto.Board;
import nl.example.pages.base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BoardPage extends BasePage {

    private static final String HEADER = "h1[class*='board-header']";
    private static final String TO_DO_LIST_HEADER = "textarea[aria-label='To Do']";
    private static final String DOING_LIST_HEADER = "textarea[aria-label='Doing']";
    private static final String DONE_LIST_HEADER = "textarea[aria-label='Done']";

    private static final String LIST_DIVISIONS = "div[class$='list-content']";
    private static final String ADD_A_CARD_IN_LIST_BUTTON = "span[class$='add-a-card']";
    private static final String CARD_TITLE_TEXTAREA = "textarea[class$='card-title']";
    private static final String ADD_CARD_BUTTON = "input[value='Add card']";

    private static final String CARD = "a[class*='list-card']";

    public void verifyDefaultElementsVisible(final Board board) {
        Assertions.assertEquals(board.getName(), header().getText());
        Assertions.assertEquals("To Do", toDoListHeader().getText());
        Assertions.assertEquals("Doing", doingListHeader().getText());
        Assertions.assertEquals("Done", doneListHeader().getText());
    }

    public void addCard(final String list, final String title) {
        listDivisions().stream()
                .filter(div -> div.getText().startsWith(list))
                .findFirst()
                .ifPresentOrElse(div -> addACardInListButton(div).click(), () -> { throw new CucumberException("Unable to find list: " + list); });

        cardTitleTextArea().sendKeys(title);
        addCardButton().click();
    }

    public void verifyCardInList(final String name, final String list) {
        WebElement listElement = listDivisions().stream()
                .filter(div -> div.getText().startsWith(list))
                .findFirst()
                .orElseThrow(() -> new CucumberException("Unable to find list: " + list));

        WebElement card = listElement.findElement(By.cssSelector(CARD));

        Assertions.assertNotNull(card);
        Assertions.assertEquals(name, card.getText(), "No card found with name: " + name);
    }

    public void openCardDetails(final String name) {
        cards().stream()
                .filter(card -> card.getText().equalsIgnoreCase(name))
                .findFirst()
                .ifPresentOrElse(WebElement::click, () -> { throw new CucumberException("Unable to find card with name: " + name); });
    }

    private WebElement header() {
        return getBrowser().findElement(HEADER);
    }

    private WebElement toDoListHeader() {
        return getBrowser().findElement(TO_DO_LIST_HEADER);
    }

    private WebElement doingListHeader() {
        return getBrowser().findElement(DOING_LIST_HEADER);
    }

    private WebElement doneListHeader() {
        return getBrowser().findElement(DONE_LIST_HEADER);
    }

    private List<WebElement> listDivisions() {
        return getBrowser().findElements(LIST_DIVISIONS);
    }

    private WebElement addACardInListButton(WebElement listElement) {
        return listElement.findElement(By.cssSelector(ADD_A_CARD_IN_LIST_BUTTON));
    }

    private WebElement cardTitleTextArea() {
        return getBrowser().findElement(CARD_TITLE_TEXTAREA);
    }

    private WebElement addCardButton() {
        return getBrowser().findElement(ADD_CARD_BUTTON);
    }

    private List<WebElement> cards() {
        return getBrowser().findElements(CARD);
    }
}
