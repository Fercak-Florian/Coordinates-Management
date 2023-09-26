package com.crystalfinance.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "coordinates")
public class Coordinates {

    public Coordinates(String id, String name, double latitude, double longitude){
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Id
    private String id;
    private String name;
    private double latitude;
    private double longitude;
}
