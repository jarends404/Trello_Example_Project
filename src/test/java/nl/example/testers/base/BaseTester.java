package nl.example.testers.base;

import io.restassured.response.Response;
import lombok.Getter;
import nl.example.common.api.Rest;

public class BaseTester {

    @Getter
    private final Rest rest = Rest.getInstance();

    protected Response response;
}
