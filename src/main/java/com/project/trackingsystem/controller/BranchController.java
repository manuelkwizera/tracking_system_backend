package com.project.trackingsystem.controller;

import com.project.trackingsystem.entity.Branch;
import com.project.trackingsystem.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
public class BranchController {
    @Autowired
    private BranchService branchService;
    @GetMapping("/api/branches")
    public ResponseEntity<List<Branch>> getAllBranches(){
        List<Branch> branches = branchService.findAllBranches();
        return new ResponseEntity<>(branches, HttpStatus.OK);
    }
    @GetMapping("/api/edit-branch/{id}")
    public ResponseEntity<Branch> getBranchById(@PathVariable Long id){
        Branch branch = branchService.findBranchById(id);
        if(branch == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(branch, HttpStatus.OK);
    }
    @PostMapping("/api/save-branch")
    public ResponseEntity<Branch> createBranch(@Validated @RequestBody Branch branch){
        Branch createdBranch = branchService.createBranch(branch);
        return new ResponseEntity<>(createdBranch, HttpStatus.CREATED);
    }
    @PutMapping("/api/update-branch/{id}")
    public ResponseEntity<Branch> updateBranch(@PathVariable Long id, @RequestBody Branch updateBranch){
        Branch branch = branchService.findBranchById(id);
        if(branch == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Branch savedBranch = branchService.updateBranch(updateBranch);
        return new ResponseEntity<>(savedBranch, HttpStatus.OK);
    }
    @DeleteMapping("/api/delete-branch/{id}")
    public ResponseEntity<Void> deleteBranch(@PathVariable long id){
        Branch branch = branchService.findBranchById(id);
        if(branch == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        branchService.deleteBranch(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
