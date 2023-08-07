package com.crystalfinance.api.service;

import com.crystalfinance.api.model.Coordinates;
import com.crystalfinance.api.repository.CoordinatesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class CoordinatesService {

    private CoordinatesRepository coordinatesRepository;

    public CoordinatesService(CoordinatesRepository coordinatesRepository){
        this.coordinatesRepository = coordinatesRepository;
    }

    public List<Coordinates> getCoordinatesList(){
        List<Coordinates> coordinatesList = coordinatesRepository.findAll();
        if(coordinatesList.isEmpty()){
            log.warn("coordinates list is empty");
            return null;
        } else {
            log.info("providing coordinates list");
            return coordinatesList;
        }
    }

    public Coordinates addCoordinates(Coordinates coordinates){
        return coordinatesRepository.insert(coordinates);
    }

    public Coordinates deleteCoordinates(String id){
        Optional<Coordinates> optionalCoordinates = coordinatesRepository.findById(id);
        if(optionalCoordinates.isEmpty()){
            log.warn("coordinates not found for this id : " + id);
            return null;
        } else {
            coordinatesRepository.deleteById(id);
            log.info("coordinates with the id " + id + " is deleted");
            return optionalCoordinates.get();
        }
    }
}
