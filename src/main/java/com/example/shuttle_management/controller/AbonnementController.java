package com.example.shuttle_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AbonnementController {

    @GetMapping("/subscribe")
    public String subscribe() {
        return "subscribe";
    }

    @PostMapping("/subscribe")
    public String processSubscription() {

        return "redirect:/shuttle";
    }
}