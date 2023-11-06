package com.project.trackingsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "vehicles")

public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_plate", nullable = true)
    private String number_plate;

    @Column(name = "starting_location", nullable = true)
    private String starting_location;

    @Column(name = "ending_location", nullable = true)
    private String ending_location;

    @Column(name = "tracking_ip", nullable = true)
    private String tracking_ip;

    @Column(name = "status", nullable = true)
    private String status;

    @Column(name = "created_at", nullable = true)
    private LocalDate created_at;

    @Column(name = "updated_at", nullable = true)
    private LocalDate updated_at;

    @PrePersist
    protected void onCreate(){
        created_at = LocalDate.now();
        updated_at = LocalDate.now();
    }
}
