package com.crystalfinance.api.controller;

import com.crystalfinance.api.exception.CoordinatesNotFoundException;
import com.crystalfinance.api.model.Coordinates;
import com.crystalfinance.api.service.CoordinatesService;
import com.crystalfinance.api.service.DistanceCalculateService;
import com.crystalfinance.api.utils.CoupleOfId;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
public class CoordinatesController {

    private long distance = 0;

    private CoordinatesService coordinatesService;
    private DistanceCalculateService distanceCalculateService;

    public CoordinatesController(CoordinatesService coordinatesService, DistanceCalculateService distanceCalculateService) {
        this.coordinatesService = coordinatesService;
        this.distanceCalculateService = distanceCalculateService;
    }

    @GetMapping("/coordinates")
    public ResponseEntity<List<Coordinates>> getCoordinatesList() {
        List<Coordinates> coordinatesList = coordinatesService.getCoordinatesList();
        return ResponseEntity.ok(coordinatesList);
    }

    @GetMapping("/coordinates/{id}")
    public ResponseEntity<Coordinates> getCoordinatesById(@PathVariable("id") String id){
        Coordinates singleCoordinates = coordinatesService.getCoordinatesById(id);
        return ResponseEntity.ok(singleCoordinates);
    }

    @PostMapping("/coordinates")
    public ResponseEntity<Object> addCoordinates(@Valid @RequestBody Coordinates coordinates, BindingResult result) {
        if (result.hasErrors()) {
            throw new CoordinatesNotFoundException("received coordinates are not valid");
        } else {
            Coordinates addedCoordinates = coordinatesService.addCoordinates(coordinates);
            return ResponseEntity.ok(addedCoordinates);
        }
    }

    @PutMapping("/coordinates/{id}")
    public ResponseEntity<Coordinates> updateCoordinates(@Valid @RequestBody Coordinates coordinates, @PathVariable("id") String id, BindingResult result){
        if(id.isBlank() || result.hasErrors()){
            throw new CoordinatesNotFoundException("received coordinates or id are not valid");
        } else {
            Coordinates updatedCoordinates = coordinatesService.updateCoordinates(coordinates, id);
            return ResponseEntity.ok(updatedCoordinates);
        }
    }

    @DeleteMapping("/coordinates/{id}")
    public ResponseEntity deleteCoordinates(@PathVariable("id") String id) {
        if (id.isBlank()) {
            throw new CoordinatesNotFoundException("received id is not valid");
        } else {
            Coordinates deletedCoordinates = coordinatesService.deleteCoordinates(id);
            return ResponseEntity.ok(deletedCoordinates);
        }
    }

    @PostMapping("/couple-of-id")
    public ResponseEntity<Long> getCoupleOfId(@Valid @RequestBody CoupleOfId coupleOfId, BindingResult result) {
        if (result.hasErrors()) {
            throw new CoordinatesNotFoundException("received ids are not valid");
        } else {
            distance = distanceCalculateService.calculateDistance(coupleOfId.getIdOne(), coupleOfId.getIdTwo());
            return ResponseEntity.ok(distance);
        }
    }
}