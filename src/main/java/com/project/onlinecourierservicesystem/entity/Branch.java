package com.project.onlinecourierservicesystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "branches")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;
    @Column(name = "image")
    private String image;
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "status", nullable = false, length = 100)
    private String status;
    @Column(name = "created_at")
    private LocalDate created_at;
    @Column(name = "updated_at")
    private LocalDate updated_at;
    @PrePersist
    protected void onCreate(){
        created_at = LocalDate.now();
    }
}
