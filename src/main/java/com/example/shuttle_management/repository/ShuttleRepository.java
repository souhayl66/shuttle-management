package com.example.shuttle_management.repository;

import com.example.shuttle_management.entity.Shuttle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface ShuttleRepository extends JpaRepository<Shuttle, Long> {
    List<Shuttle> findByDepartureCityAndArrivalCity(String departureCity, String arrivalCity);
    List<Shuttle> findByDepartureCityAndArrivalCityAndDepartureTime(String departureCity, String arrivalCity, LocalTime departureTime);
}