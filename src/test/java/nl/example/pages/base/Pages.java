package nl.example.pages.base;

import nl.example.pages.BoardPage;
import nl.example.pages.BoardsPage;
import nl.example.pages.CommonPage;
import nl.example.pages.LoginPage;

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

}
