package nl.example.pages;

import nl.example.pages.base.BasePage;
import org.openqa.selenium.WebElement;

public class CardPage extends BasePage {

    private static final String CURRENT_LIST_BUTTON = "a[class*='open-move-from']";
    private static final String SELECT_LIST_SELECT = "select[class*='select-list']";
    private static final String MOVE_BUTTON = "input[value*='Move']";
    private static final String CLOSE_BUTTON = "a[class*='dialog-close-button']";

    public void moveCardToList(final String list) {
        currentListButton().click();
        selectListSelect().sendKeys(list);
        moveButton().click();
        closeButton().click();
    }

    private WebElement currentListButton() {
        return getBrowser().findElement(CURRENT_LIST_BUTTON);
    }

    private WebElement selectListSelect() {
        return getBrowser().findElement(SELECT_LIST_SELECT);
    }

    private WebElement moveButton() {
        return getBrowser().findElement(MOVE_BUTTON);
    }

    private WebElement closeButton() {
        return getBrowser().findElement(CLOSE_BUTTON);
    }

}
