package nl.example.pages.base;

import nl.example.util.Browser;
import org.junit.jupiter.api.Assertions;

public class BasePage {

    protected Browser browser = Browser.getInstance();

    protected void isAt(String url) {
        Assertions.assertTrue(browser.getCurrentUrl().contains(url));
    }

}
