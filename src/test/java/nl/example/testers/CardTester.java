package nl.example.testers;

import io.restassured.response.Response;
import nl.example.common.api.QueryParameter;
import nl.example.data.dto.Card;
import nl.example.testers.base.BaseTester;
import org.junit.jupiter.api.Assertions;

public class CardTester extends BaseTester {

    private static final String POST_CARD_ENDPOINT = "/1/cards";

    public void createCard(Card card, String listId) {
        QueryParameter name = new QueryParameter("name", card.getName());
        QueryParameter list = new QueryParameter("idList", listId);
        Response response = getRest().addQueryParameter(name, list).postRequest(POST_CARD_ENDPOINT);

        Assertions.assertEquals(card.getName(), response.then().extract().path("name"));
    }

}
