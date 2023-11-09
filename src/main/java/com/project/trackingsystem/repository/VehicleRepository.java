package com.project.trackingsystem.repository;

import com.project.trackingsystem.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("SELECT v FROM Vehicle v WHERE LOWER(v.starting_location) LIKE :startingLocation AND LOWER(v.ending_location) LIKE :endLocation")
    List<Vehicle> findVehiclesWithCustomPattern(@Param("startingLocation") String startingLocation, @Param("endLocation") String endLocation);
}



