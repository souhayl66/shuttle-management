package com.example.shuttle_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemandeController {

    @GetMapping("/demande")
    public String demande(Model model) {

        return "demande";
    }
}