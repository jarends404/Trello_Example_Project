package nl.example.pages;

import nl.example.pages.base.BasePage;

public class CommonPage extends BasePage {

    public void navigateTo(final String uri) {
        getBrowser().get(uri);
    }

}
