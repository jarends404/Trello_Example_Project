package nl.example.pages.base;

import lombok.Getter;
import nl.example.common.web.Browser;
import org.junit.jupiter.api.Assertions;

public class BasePage {

    @Getter
    private final Browser browser = Browser.getInstance();

    protected void isAt(final String uri) {
        browser.waitUntilUrlContains(uri);
        Assertions.assertTrue(browser.getCurrentUrl().contains(uri));
    }

}
