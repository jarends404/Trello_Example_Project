package nl.example.data.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BoardResponse {
    private String id;
    private String url;
    private String name;
}
