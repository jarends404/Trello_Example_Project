package nl.example.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QueryParameter {
    private String key;
    private String value;
}
