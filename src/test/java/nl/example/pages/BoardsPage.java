package nl.example.pages;

import nl.example.pages.base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

public class BoardsPage extends BasePage {

    private static final String WORKSPACES_HEADER = "h3[class='boards-page-section-header-name']";

    public void verifyOnPage() {
        isAt("/boards");
        Assertions.assertEquals("YOUR WORKSPACES", workspacesHeader().getText());
    }

    private WebElement workspacesHeader() {
        return getBrowser().findElement(WORKSPACES_HEADER);
    }

}
