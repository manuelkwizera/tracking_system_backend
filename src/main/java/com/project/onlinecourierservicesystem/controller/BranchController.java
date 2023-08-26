package com.project.onlinecourierservicesystem.controller;

import com.project.onlinecourierservicesystem.entity.Branch;
import com.project.onlinecourierservicesystem.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(branch, HttpStatus.OK);
    }
    @PostMapping("/api/save-branch")
    public ResponseEntity<?> createBranch(@Validated @RequestBody Branch branch){
        Branch createdBranch = branchService.createBranch(branch);
        return new ResponseEntity<>(createdBranch, HttpStatus.CREATED);
    }

    @GetMapping("/branches")
    public String findAllBranches(Model model){
        List<Branch> branches = branchService.findAllBranches();
        model.addAttribute("page_title", "Branches");
        model.addAttribute("branches", branches);
        return "branch/index";
    }
    @GetMapping("/add-branch")
    public String addBranch(Branch branch, Model model){
        model.addAttribute("page_title", "Add Branch");
        model.addAttribute("form_name", "Branch Form");
        return "branch/add";
    }
    @PostMapping("/save-branch")
    public String saveBranch(@Validated @ModelAttribute Branch branch, BindingResult result, Model model){
        /*if(result.hasErrors()){
            model.addAttribute("errors", result.getAllErrors());
            model.addAttribute("branch", branch);
            return "redirect:/add-branch";
        }*/

        branchService.createBranch(branch);
        model.addAttribute("branches", branchService.findAllBranches());
        return "redirect:/branches";
    }
    @GetMapping("/remove-branch/{id}")
    public String deleteBranch(@PathVariable Long id, Model model){
        branchService.deleteBranch(id);
        model.addAttribute("branches", branchService.findAllBranches());
        return "redirect:/branches";
    }
    @GetMapping("/edit-branch/{id}")
    public String editBranch(@PathVariable Long id, Model model){
        model.addAttribute("page_title", "Edit Branch");
        model.addAttribute("branch", branchService.findBranchById(id));
        return "branch/edit";
    }
    @PostMapping("/update-branch/{id}")
    public String updateBranch(@PathVariable Long id, Branch branch, BindingResult result, Model model){
        /*if(result.hasErrors()){
            return "redirect:/edit-branch";
        }*/
        branchService.updateBranch(branch);
        model.addAttribute("branches", branchService.findAllBranches());
        return "redirect:/branches";
    }
}
