package com.project.trackingsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name", nullable = true)
    private String item_name;

    @Column(name = "weight", nullable = true)
    private String weight;

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
