package nl.example.pages;

import nl.example.pages.base.BasePage;

public class InventoryPage extends BasePage {

    private static final String URL = "/inventory";

    public void isAt() {
        isAt(URL);
    }
}
