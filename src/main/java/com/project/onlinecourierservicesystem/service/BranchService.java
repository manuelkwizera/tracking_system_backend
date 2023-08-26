package com.project.onlinecourierservicesystem.service;

import com.project.onlinecourierservicesystem.entity.Branch;
import com.project.onlinecourierservicesystem.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BranchService {
    @Autowired
    private BranchRepository branchRepository;

    public List<Branch> findAllBranches(){
        return branchRepository.findAll();
    }
    public Branch findBranchById(Long id){
        Branch branch = branchRepository.findById(id).orElseThrow(() -> new RuntimeException("branch not found"));
        return branch;
    }
    public Branch createBranch(Branch branch){
        branchRepository.save(branch);
        return branch;
    }
    public Branch updateBranch(Branch branch){
        branchRepository.save(branch);
        return branch;
    }
    public void deleteBranch(Long id){
        Branch branch = branchRepository.findById(id).orElseThrow(() -> new RuntimeException("branch not found"));
        branchRepository.deleteById(branch.getId());
    }
}
