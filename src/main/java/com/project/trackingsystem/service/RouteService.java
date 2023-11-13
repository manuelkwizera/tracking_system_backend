package com.project.trackingsystem.service;

import com.project.trackingsystem.entity.Route;
import com.project.trackingsystem.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;

    public List<Route> findAllRoutes(){
        return routeRepository.findAll();
    }

    public Route findRouteById(Long id){
        Route Route = routeRepository.findById(id).orElseThrow(() -> new RuntimeException("Route not found"));
        return Route;
    }
    public Route createRoute(Route Route){
        routeRepository.save(Route);
        return Route;
    }
    public Route updateRoute(Route Route){
        routeRepository.save(Route);
        return Route;
    }
    public void deleteRoute(Long id){
        Route Route = routeRepository.findById(id).orElseThrow(() -> new RuntimeException("Route not found"));
        routeRepository.deleteById(Route.getId());
    }
}
