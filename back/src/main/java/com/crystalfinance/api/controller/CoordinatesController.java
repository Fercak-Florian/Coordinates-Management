package com.crystalfinance.api.controller;

import com.crystalfinance.api.model.Coordinates;
import com.crystalfinance.api.service.CoordinatesService;
import com.crystalfinance.api.service.DistanceCalculateService;
import com.crystalfinance.api.utils.CoupleOfId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CoordinatesController {

    private long distance = 0;

    private CoordinatesService coordinatesService;
    private DistanceCalculateService distanceCalculateService;

    public CoordinatesController(CoordinatesService coordinatesService, DistanceCalculateService distanceCalculateService) {
        this.coordinatesService = coordinatesService;
        this.distanceCalculateService = distanceCalculateService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Coordinates>> getCoordinatesList() {
        List<Coordinates> coordinatesList = coordinatesService.getCoordinatesList();
        log.info("display home page");
        return ResponseEntity.ok(coordinatesList);
    }

    @PostMapping("/coordinates")
    public ResponseEntity<Coordinates> addCoordinates(@RequestBody Coordinates coordinates) {
        Coordinates addedCoordinates = coordinatesService.addCoordinates(coordinates);
        return ResponseEntity.ok(addedCoordinates);
    }

    @DeleteMapping("/coordinates/{id}")
    public ResponseEntity deleteCoordinates(@PathVariable("id") String id) {
        Coordinates deletedCoordinates = coordinatesService.deleteCoordinates(id);
        return ResponseEntity.ok(deletedCoordinates);
    }

    @PostMapping("/couple-of-id")
    public ResponseEntity<Long> getCoupleOfId(@RequestBody CoupleOfId coupleOfId) {
        distance = distanceCalculateService.calculateDistance(coupleOfId.getIdOne(), coupleOfId.getIdTwo());
        return ResponseEntity.ok(distance);
    }
}
