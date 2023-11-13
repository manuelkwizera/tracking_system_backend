package com.project.trackingsystem.service;

import com.project.trackingsystem.entity.Vehicle;
import com.project.trackingsystem.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository VehicleRepository;

    public List<Vehicle> findAllVehicles(){
        return VehicleRepository.findAll();
    }
    public Vehicle findVehicleById(Long id){
        Vehicle Vehicle = VehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        return Vehicle;
    }
    public Vehicle createVehicle(Vehicle Vehicle){
        VehicleRepository.save(Vehicle);
        return Vehicle;
    }
    public Vehicle updateVehicle(Vehicle Vehicle){
        VehicleRepository.save(Vehicle);
        return Vehicle;
    }
    public void deleteVehicle(Long id){
        Vehicle Vehicle = VehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        VehicleRepository.deleteById(Vehicle.getId());
    }

    public List<Vehicle> getVehiclesByLocation(String startingLocation, String endingLocation){
        return VehicleRepository.findVehiclesWithCustomPattern(startingLocation, endingLocation);
    }
}
