package nl.example.common.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import nl.example.common.env.Environment;
import org.apache.commons.text.StringSubstitutor;

import java.util.HashMap;
import java.util.Map;

public class Rest {

    private final RequestSpecification request;

    public Rest() {
        Environment environment = Environment.getInstance();

        request = RestAssured.given();
        request.baseUri(environment.getProperty("apiBaseUrl"));
        request.queryParam("key", environment.getProperty("apiKey"));
        request.queryParam("token", environment.getProperty("token"));
        request.contentType("application/json");
    }

    public Rest addQueryParameter(QueryParameter... parameters) {
        for (QueryParameter parameter : parameters) {
            request.queryParam(parameter.getKey(), parameter.getValue());
        }
        return this;
    }

    public Response getRequest(final String endpoint) {
        return request.when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .and().extract().response();
    }

    public Response postRequest(final String endpoint) {
        return request.when()
                .post(endpoint)
                .then()
                .statusCode(200)
                .and().extract().response();
    }

    public Response putRequest(final String endpoint, final String id) {
        String formattedEndpoint = formatId(endpoint, id);

        return request.when()
                .put(formattedEndpoint)
                .then()
                .statusCode(200)
                .and().extract().response();
    }

    public Response deleteRequest(final String endpoint, final String id) {
        String formattedEndpoint = formatId(endpoint, id);

        return request.when()
                .delete(formattedEndpoint)
                .then()
                .statusCode(200)
                .and().extract().response();
    }

    private String formatId(final String endpoint, final String id) {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        return StringSubstitutor.replace(endpoint, map, "{", "}");
    }

}
