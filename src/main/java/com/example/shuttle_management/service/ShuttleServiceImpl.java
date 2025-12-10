package com.example.shuttle_management.service;

import com.example.shuttle_management.entity.Shuttle;
import com.example.shuttle_management.repository.ShuttleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class ShuttleServiceImpl implements ShuttleService {

    @Autowired
    private ShuttleRepository shuttleRepository;

    @Override
    public List<Shuttle> getAllShuttles() {
        return shuttleRepository.findAll();
    }

    @Override
    public String addShuttle(Shuttle shuttle) {
        if (shuttleRepository.count() >= 50) {
            return "Maximum shuttle limit (50) reached. Cannot add more.";
        }
        shuttleRepository.save(shuttle);
        return "Shuttle added successfully.";
    }

    @Override
    public List<Shuttle> findShuttlesByCities(String departureCity, String arrivalCity) {
        return shuttleRepository.findByDepartureCityAndArrivalCity(departureCity, arrivalCity);
    }

    @Override
    public List<Shuttle> findShuttlesByCitiesAndTime(String departureCity, String arrivalCity, LocalTime departureTime) {
        return shuttleRepository.findByDepartureCityAndArrivalCityAndDepartureTime(departureCity, arrivalCity, departureTime);
    }
}