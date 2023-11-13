package com.project.trackingsystem.controller;

import com.project.trackingsystem.entity.Branch;
import com.project.trackingsystem.entity.Route;
import com.project.trackingsystem.entity.Vehicle;
import com.project.trackingsystem.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
public class RouteController {
    @Autowired
    private RouteService routeService;

    @GetMapping("/api/routes")
    public ResponseEntity<List<Route>> getAllRoutes(){
        List<Route> routes = routeService.findAllRoutes();
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    @GetMapping("/api/edit-route/{id}")
    public ResponseEntity<Route> getRouteById(@PathVariable Long id){
        Route route = routeService.findRouteById(id);
        if(route == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(route, HttpStatus.OK);
    }

    @PostMapping("/api/save-route")
    public ResponseEntity<Route> createRoute(@Validated @RequestBody Route route){
        Route createRoute = routeService.createRoute(route);
        return new ResponseEntity<>(createRoute, HttpStatus.CREATED);
    }

    @PutMapping("/api/update-route/{id}")
    public ResponseEntity<Route> updateRoute(@PathVariable Long id, @RequestBody Route route){
        Route routeFound = routeService.findRouteById(id);
        if(routeFound == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Route newRoute = routeService.updateRoute(route);
        return new ResponseEntity<>(newRoute, HttpStatus.OK);
    }
}
