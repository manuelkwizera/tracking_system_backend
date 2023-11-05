package com.project.trackingsystem.controller;

import com.project.trackingsystem.entity.Vehicle;
import com.project.trackingsystem.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
public class VehicleController {
    @Autowired
    private VehicleService VehicleService;

    @GetMapping("/api/vehicles")
    public ResponseEntity<List<Vehicle>> getAllVehicles(){
        List<Vehicle> Vehicles = VehicleService.findAllVehicles();
        return new ResponseEntity<>(Vehicles, HttpStatus.OK);
    }

    @GetMapping("/api/edit-vehicle/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id){
        Vehicle Vehicle = VehicleService.findVehicleById(id);
        if(Vehicle == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Vehicle, HttpStatus.OK);
    }

    @PostMapping("/api/save-vehicle")
    public ResponseEntity<Vehicle> createVehicle(@Validated @RequestBody Vehicle Vehicle){
        Vehicle createdVehicle = VehicleService.createVehicle(Vehicle);
        return new ResponseEntity<>(createdVehicle, HttpStatus.CREATED);
    }

    @PutMapping("/api/update-vehicle/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle updateVehicle){
        Vehicle Vehicle = VehicleService.findVehicleById(id);
        if(Vehicle == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Vehicle savedVehicle = VehicleService.updateVehicle(updateVehicle);
        return new ResponseEntity<>(savedVehicle, HttpStatus.OK);
    }
    @DeleteMapping("/api/delete-vehicle/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable long id){
        Vehicle Vehicle = VehicleService.findVehicleById(id);
        if(Vehicle == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        VehicleService.deleteVehicle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
