package nl.example.common.api;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryParameter {
    private String key;
    private String value;
}
