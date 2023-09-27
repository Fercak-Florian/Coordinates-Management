package com.crystalfinance.api.model;

import jakarta.validation.constraints.DecimalMin;
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
    private String id;

    @NotEmpty(message = "name field cannot be empty")
    private String name;

    @DecimalMin(value = "0.001", message = "please enter a value greater than 0.001")
    private double latitude;

    @DecimalMin(value = "0.001", message = "please enter a value greater than 0.001")
    private double longitude;
}
