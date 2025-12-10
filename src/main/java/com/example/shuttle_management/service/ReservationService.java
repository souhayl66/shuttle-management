package com.example.shuttle_management.service;

import com.example.shuttle_management.entity.User;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    public String bookShuttle(User user) {
        if (!user.hasActiveAbonnement()) {
            return "You need an active subscription to book a shuttle.";
        }
        return "Shuttle booked successfully.";
    }
}