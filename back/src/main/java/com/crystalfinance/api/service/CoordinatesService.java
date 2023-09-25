package com.crystalfinance.api.service;

import com.crystalfinance.api.exception.CoordinatesNotFoundException;
import com.crystalfinance.api.model.Coordinates;
import com.crystalfinance.api.repository.CoordinatesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This class contains necessary methods to get, add and delete Coordinates
 * This class uses the CoordinatesRepository interface to perform this actions
 */
@Slf4j
@Service
public class CoordinatesService {

    private CoordinatesRepository coordinatesRepository;

    public CoordinatesService(CoordinatesRepository coordinatesRepository) {
        this.coordinatesRepository = coordinatesRepository;
    }

    /**
     * This method finds all Coordinates
     *
     * @return a list of Coordinates
     */
    public List<Coordinates> getCoordinatesList() {
        return coordinatesRepository.findAll();
    }

    /**
     * This method saves a Coordinates
     *
     * @param coordinates to save
     * @return the saved Coordinates
     */
    public Coordinates addCoordinates(Coordinates coordinates) {
        return coordinatesRepository.insert(coordinates);
    }

    /**
     * This method finds a Coordinates and deletes it
     *
     * @param id of coordinates in database
     */
    public Coordinates deleteCoordinates(String id) {
        Optional<Coordinates> optionalCoordinates = coordinatesRepository.findById(id);
        if (optionalCoordinates.isPresent()) {
            coordinatesRepository.deleteById(id);
            return optionalCoordinates.get();
        } else {
            throw new CoordinatesNotFoundException("no coordinates found with id : " + id);
        }
    }
}
