package nl.example.data.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Board {
    private String name;
    private boolean defaultLabels;
    private boolean defaultLists;
    private String desc;
    private String idOrganization;
}
