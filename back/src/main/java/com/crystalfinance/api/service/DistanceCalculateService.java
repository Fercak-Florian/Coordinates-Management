package com.crystalfinance.api.service;

import com.crystalfinance.api.exception.CoordinatesNotFoundException;
import com.crystalfinance.api.model.Coordinates;
import com.crystalfinance.api.repository.CoordinatesRepository;
import lombok.extern.slf4j.Slf4j;
import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicData;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class DistanceCalculateService {

    private CoordinatesRepository coordinatesRepository;

    public DistanceCalculateService(CoordinatesRepository coordinatesRepository) {
        this.coordinatesRepository = coordinatesRepository;
    }

    public long calculateDistance(String idOne, String idTwo) {
        long distance = 0;
        Coordinates coordinatesOne;
        Coordinates coordinatesTwo;

        Optional<Coordinates> optionalCoordinatesOne = coordinatesRepository.findById(idOne);
        Optional<Coordinates> optionalCoordinatesTwo = coordinatesRepository.findById(idTwo);

        if (optionalCoordinatesOne.isPresent() && optionalCoordinatesTwo.isPresent()) {
            coordinatesOne = optionalCoordinatesOne.get();
            coordinatesTwo = optionalCoordinatesTwo.get();

            GeodesicData geodesic = Geodesic.WGS84.Inverse(coordinatesOne.getLatitude(), coordinatesOne.getLongitude(), coordinatesTwo.getLatitude(), coordinatesTwo.getLongitude());
            double distanceInMeters = geodesic.s12;
            double distanceInKilometers = distanceInMeters / 1000;
            return Math.round(distanceInKilometers);
        } else{
            throw new CoordinatesNotFoundException("no coordinates found with ids : " + idOne + " and " + idTwo);
        }
    }
}
