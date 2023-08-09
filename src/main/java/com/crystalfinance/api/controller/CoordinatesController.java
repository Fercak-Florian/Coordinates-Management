package com.crystalfinance.api.controller;

import com.crystalfinance.api.model.Coordinates;
import com.crystalfinance.api.service.CoordinatesService;
import com.crystalfinance.api.utils.CoupleOfId;
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
        model.addAttribute("coordinatesList", coordinatesList);
        model.addAttribute("coordinates", new Coordinates());
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
        System.out.println(coupleOfId.getIdOne());
        System.out.println(coupleOfId.getIdTwo());
        return "redirect:/";
    }
}
