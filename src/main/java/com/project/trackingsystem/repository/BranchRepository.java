package com.project.trackingsystem.repository;

import com.project.trackingsystem.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
