package com.crystalfinance.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "coordinates")
public class Coordinates {

    @Id
    private String id;
    private String name;
    private String latitude;
    private String longitude;
}
