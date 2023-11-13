package com.project.trackingsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = true)
    private Integer code;

    @Column(name = "date", nullable = true)
    private LocalDate date;

    @Column(name = "time", nullable = true)
    private LocalTime time;

    @Column(name = "shipping_from", nullable = true)
    private String shipping_from;

    @Column(name = "deliver_to", nullable = true)
    private String deliver_to;

    @Column(name = "vehicle_id", nullable = true)
    private Integer vehicle_id;

    @Column(name = "distance", nullable = true)
    private String distance;

    @Column(name = "duration", nullable = true)
    private String duration;

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
