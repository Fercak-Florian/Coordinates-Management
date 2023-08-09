package com.crystalfinance.api.controller;

import com.crystalfinance.api.model.Coordinates;
import com.crystalfinance.api.service.CoordinatesService;
import com.crystalfinance.api.service.DistanceCalculateService;
import com.crystalfinance.api.utils.CoupleOfId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class CoordinatesController {

    private long distance = 0;

    private CoordinatesService coordinatesService;
    private DistanceCalculateService distanceCalculateService;

    public CoordinatesController(CoordinatesService coordinatesService, DistanceCalculateService distanceCalculateService){
        this.coordinatesService = coordinatesService;
        this.distanceCalculateService = distanceCalculateService;
    }

    @GetMapping("/")
    public String getCoordinatesList(Model model){
        List<Coordinates> coordinatesList = coordinatesService.getCoordinatesList();
        model.addAttribute("coordinatesList", coordinatesList);
        model.addAttribute("coordinates", new Coordinates());
        log.info("display home page");
        return "home";
    }

    @PostMapping("/coordinates")
    public String addCoordinates(@ModelAttribute Coordinates coordinates){
        coordinatesService.addCoordinates(coordinates);
        return "redirect:/";
    }

    @GetMapping("/coordinates/{id}")
    public String deleteCoordinates(@PathVariable("id") String id) {
        coordinatesService.deleteCoordinates(id);
        return "redirect:/";
    }

    @PostMapping("/couple-of-id")
    public String getCoupleOfId(@ModelAttribute CoupleOfId coupleOfId){
        distance = distanceCalculateService.calculateDistance(coupleOfId.getIdOne(), coupleOfId.getIdTwo());
        return "redirect:/result";
    }

    @GetMapping("/result")
    public String displayResult(Model model){
        if(distance > 10){
            model.addAttribute("distance", distance);
            log.info("display the result on 'more' page");
            return "more";
        } else{
            model.addAttribute("distance", distance);
            log.info("display the result on 'less' page");
            return "less";
        }
    }
}
