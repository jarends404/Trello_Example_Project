package nl.example.pages;

import nl.example.data.dto.Board;
import nl.example.pages.base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

public class BoardPage extends BasePage {

    private static final String HEADER = "h1[class*='board-header']";
    private static final String TO_DO_LIST_HEADER = "textarea[aria-label='To Do']";
    private static final String DOING_LIST_HEADER = "textarea[aria-label='Doing']";
    private static final String DONE_LIST_HEADER = "textarea[aria-label='Done']";

    public void verifyDefaultElementsVisible(final Board board) {
        Assertions.assertEquals(board.getName(), header().getText());
        Assertions.assertEquals("To Do", toDoListHeader().getText());
        Assertions.assertEquals("Doing", doingListHeader().getText());
        Assertions.assertEquals("Done", doneListHeader().getText());
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
}
