package nl.example.pages;

import io.cucumber.core.exception.CucumberException;
import nl.example.pages.base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CardPage extends BasePage {

    private static final String CURRENT_LIST_BUTTON = "a[class*='open-move-from']";
    private static final String SELECT_LIST_SELECT = "select[class*='select-list']";
    private static final String MOVE_BUTTON = "input[value*='Move']";
    private static final String CLOSE_BUTTON = "a[class*='dialog-close-button']";
    private static final String ADD_LABEL_BUTTON = "a[title='Labels']";
    private static final String EDIT_LABEL_BUTTON = "span[aria-label='EditIcon']";
    private static final String LABEL_TITLE_FIELD = "input[class*='textfield__input']";
    private static final String EDIT_LABEL_POPOVER_BUTTON = "section[data-test-id*='label'] button[type='button']";
    private static final String CLOSE_POPOVER_BUTTON = "button[data-test-id='popover-close']";
    private static final String LABELS_CONTAINER = "div[data-test-id*='labels-container']";
    private static final String CARD_LABEL = "div[data-test-id='card-label']";
    private static final String LABEL = "button[data-test-id='card-label']";

    public void moveCardToList(final String list) {
        currentListButton().click();
        selectListSelect().sendKeys(list);
        moveButton().click();
        closeButton().click();
    }

    public void addLabel(final String title) {
        addLabelButton().click();
        editLabelButton().click();
        labelTitleField().sendKeys(title);
        editLabelPopoverButton("Save").click();
        cardLabel().click();
        closePopoverButton().click();
    }

    public void verifyLabelVisible(final String title) {
        Assertions.assertEquals(title, firstLabel().getText(), "No label found with title: " + title);
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

    private WebElement addLabelButton() {
        return getBrowser().findElement(ADD_LABEL_BUTTON);
    }

    private WebElement editLabelButton() {
        return getBrowser().findElement(EDIT_LABEL_BUTTON);
    }

    private WebElement labelTitleField() {
        return getBrowser().findElement(LABEL_TITLE_FIELD);
    }

    private WebElement editLabelPopoverButton(final String button) {
        return getBrowser().findElements(EDIT_LABEL_POPOVER_BUTTON).stream()
                .filter(elem -> elem.getText().equalsIgnoreCase(button))
                .findFirst()
                .orElseThrow(() -> new CucumberException("Unable to find button: " + button));
    }

    private WebElement cardLabel() {
        return getBrowser().findElement(CARD_LABEL);
    }

    private WebElement closePopoverButton() {
        return getBrowser().findElement(CLOSE_POPOVER_BUTTON);
    }

    private WebElement labelsContainer() {
        return getBrowser().findElement(LABELS_CONTAINER);
    }

    private WebElement firstLabel() {
        return labelsContainer().findElement(By.cssSelector(LABEL));
    }
}
