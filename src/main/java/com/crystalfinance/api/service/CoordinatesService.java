package com.crystalfinance.api.service;

import com.crystalfinance.api.model.Coordinates;
import com.crystalfinance.api.repository.CoordinatesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordinatesService {

    private CoordinatesRepository coordinatesRepository;

    public CoordinatesService(CoordinatesRepository coordinatesRepository){
        this.coordinatesRepository = coordinatesRepository;
    }

    public List<Coordinates> getCoordinatesList(){
        return coordinatesRepository.findAll();
    }

    public Coordinates addCoordinates(Coordinates coordinates){
        return coordinatesRepository.save(coordinates);
    }
}
