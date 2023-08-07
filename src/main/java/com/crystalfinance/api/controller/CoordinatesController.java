package com.crystalfinance.api.controller;

import com.crystalfinance.api.model.Coordinates;
import com.crystalfinance.api.service.CoordinatesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoordinatesController {

    private CoordinatesService coordinatesService;

    public CoordinatesController(CoordinatesService coordinatesService){
        this.coordinatesService = coordinatesService;
    }

    @GetMapping("/")
    public List<Coordinates> getCoordinatesList(){
        return coordinatesService.getCoordinatesList();
    }
}
