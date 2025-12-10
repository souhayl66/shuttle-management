package com.example.shuttle_management.controller;

import com.example.shuttle_management.entity.Shuttle;
import com.example.shuttle_management.service.ShuttleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;
import java.util.List;

@Controller
public class ShuttleViewController {

    @Autowired
    private ShuttleService shuttleService;

    @GetMapping("/search")
    public String searchShuttles(
            @RequestParam(required = false) String departureCity,
            @RequestParam(required = false) String arrivalCity,
            @RequestParam(required = false) String departureTime,
            Model model) {

        List<Shuttle> shuttles;

        if (departureCity != null && arrivalCity != null && departureTime != null) {

            LocalTime time = LocalTime.parse(departureTime);


            shuttles = shuttleService.findShuttlesByCitiesAndTime(departureCity, arrivalCity, time);
        } else {

            shuttles = shuttleService.getAllShuttles();
        }


        model.addAttribute("departureCity", departureCity);
        model.addAttribute("arrivalCity", arrivalCity);
        model.addAttribute("departureTime", departureTime);
        model.addAttribute("shuttles", shuttles);

        return "search-results";
    }
}