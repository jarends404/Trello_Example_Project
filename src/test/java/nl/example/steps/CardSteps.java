package nl.example.steps;

import nl.example.data.dto.Card;
import nl.example.steps.base.BaseSteps;
import nl.example.testers.CardTester;

public class CardSteps extends BaseSteps {

    private final CardTester cardTester = new CardTester();
    private final Card card = getData().getCard();


}
