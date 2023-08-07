package com.crystalfinance.api.controller;

import com.crystalfinance.api.model.Coordinates;
import com.crystalfinance.api.service.CoordinatesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CoordinatesController {

    private CoordinatesService coordinatesService;

    public CoordinatesController(CoordinatesService coordinatesService){
        this.coordinatesService = coordinatesService;
    }

    @GetMapping("/")
    public String getCoordinatesList(Model model){
        List<Coordinates> coordinatesList = coordinatesService.getCoordinatesList();
        model.addAttribute("coordinates", coordinatesList);
        return "home";
    }

    @PostMapping("/coordinates")
    public Coordinates addCoordinates(@RequestBody Coordinates coordinates){
        return coordinatesService.addCoordinates(coordinates);
    }

    @DeleteMapping("/coordinates/{id}")
    public Coordinates deleteCoordinates(@PathVariable("id") String id) {
        return coordinatesService.deleteCoordinates(id);
    }
}
