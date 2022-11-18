package nl.example.data.base;

import com.github.javafaker.Faker;
import lombok.Getter;
import nl.example.data.AtlassianAccount;
import nl.example.data.dto.Board;
import nl.example.data.dto.Card;

import java.util.Locale;

public class TestData {

    private static TestData testData;

    private static final Faker FAKER = new Faker(Locale.ENGLISH);
    private static final String WORKSPACE = "test_workspace";

    private TestData() {

    }

    public static TestData getInstance() {
        if (testData == null) {
            testData = new TestData();
        }
        return testData;
    }

    @Getter
    private final AtlassianAccount atlassianAccount = AtlassianAccount.getInstance();

    public Board getBoard() {
        return Board.builder()
                .name("test_board_" + FAKER.number().digits(5))
                .defaultLabels(true)
                .defaultLists(true)
                .desc(FAKER.harryPotter().quote())
                .build();
    }

    public Card getCard() {
        return Card.builder()
                .name("test_card_" + FAKER.number().digits(5))
                .description(FAKER.harryPotter().quote())
                .build();
    }

}
