package nl.example.testers.base;

import lombok.Getter;
import nl.example.common.api.Rest;

public class BaseTester {

    @Getter
    private final Rest rest = new Rest();

}
