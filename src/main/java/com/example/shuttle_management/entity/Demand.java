package com.example.shuttle_management.entity;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import java.time.LocalTime;
import java.time.LocalDate;

@Data
@Entity
public class Demand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String departureCity = "Kenitra";
    private String arrivalCity = "Rabat";

    @NotNull
    private LocalTime departureTime;

    private LocalTime arrivalTime;

    private LocalDate startDate;
    private LocalDate endDate;
    private int interestedUsers = 1;


    public LocalTime getArrivalTime() {
        if (departureTime != null) {
            return departureTime.plusMinutes(30);
        }
        return null;
    }


    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
        this.arrivalTime = departureTime != null ? departureTime.plusMinutes(30) : null;
    }
}