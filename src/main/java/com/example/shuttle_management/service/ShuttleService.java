package com.example.shuttle_management.service;

import com.example.shuttle_management.entity.Shuttle;
import java.time.LocalTime;
import java.util.List;

public interface ShuttleService {
    List<Shuttle> getAllShuttles();
    String addShuttle(Shuttle shuttle);
    List<Shuttle> findShuttlesByCities(String departureCity, String arrivalCity);
    List<Shuttle> findShuttlesByCitiesAndTime(String departureCity, String arrivalCity, LocalTime departureTime);
}