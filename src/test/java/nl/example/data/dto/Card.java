package nl.example.data.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Card {
    private String title;
    private String description;
}
