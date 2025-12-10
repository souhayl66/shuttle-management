package com.example.shuttle_management.controller;

import com.example.shuttle_management.entity.Shuttle;
import com.example.shuttle_management.service.ShuttleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalTime;

@Controller
public class ShuttleController {

    @Autowired
    private ShuttleService shuttleService;

    @GetMapping("/shuttle")
    public String showShuttleForm(Model model) {
        model.addAttribute("shuttle", new Shuttle());
        return "shuttle";
    }


    @PostMapping("/shuttle")
    public String addShuttle(@ModelAttribute Shuttle shuttle, Model model) {

        if (shuttle.getDepartureCity() == null || shuttle.getArrivalCity() == null || shuttle.getDepartureTime() == null) {
            model.addAttribute("error", "Tous les champs sont obligatoires.");
            return "shuttle";
        }


        shuttle.setCurrentSubscribers(0);


        shuttleService.addShuttle(shuttle);


        return "redirect:/search";
    }
}