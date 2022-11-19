package nl.example.pages.base;

import nl.example.pages.*;

public class Pages {

    private static Pages pages;

    private Pages() {

    }

    public static Pages getInstance() {
        if (pages == null) {
            pages = new Pages();
        }
        return pages;
    }

    public CommonPage common = new CommonPage();
    public LoginPage login = new LoginPage();
    public BoardsPage boards = new BoardsPage();
    public BoardPage board = new BoardPage();
    public CardPage card = new CardPage();

}
