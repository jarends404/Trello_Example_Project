package nl.example.steps.base;

import lombok.Getter;
import nl.example.data.base.TestData;
import nl.example.pages.base.Pages;

public class BaseSteps {

    @Getter
    private final Pages pages = Pages.getInstance();
    @Getter
    private final TestData data = TestData.getInstance();

}
