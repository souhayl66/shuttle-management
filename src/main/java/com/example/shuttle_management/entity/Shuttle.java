package com.example.shuttle_management.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalTime;

@Data
@Entity
public class Shuttle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departureCity;
    private String arrivalCity;

    private LocalTime departureTime;
    private LocalTime arrivalTime;

    private int maxSubscribers;
    private int currentSubscribers;


    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
        this.arrivalTime = departureTime.plusMinutes(30);
    }
}