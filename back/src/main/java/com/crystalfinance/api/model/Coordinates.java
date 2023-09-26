package com.crystalfinance.api.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "id field cannot be empty")
    private String id;

    @NotEmpty(message = "name field cannot be empty")
    private String name;

    @NotEmpty(message = "latitude field cannot be empty")
    private double latitude;

    @NotEmpty(message = "longitude field cannot be empty")
    private double longitude;
}
