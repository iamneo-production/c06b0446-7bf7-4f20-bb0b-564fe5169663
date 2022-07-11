package com.example.controllers;

import com.example.dto.jobseekerDTO;
import com.example.models.Jobseeker;
import com.example.security.services.JobseekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

@RequestMapping("/jobseeker")
public class JobseekerController {
    @Autowired
    private JobseekerService service;


    @GetMapping("/getAppliedJobs")
    public List<Jobseeker> getAllByUsername(){
        return service.getAllByUsername();
    }


    @DeleteMapping("/deleteJobs/{id}")
    public String deleteJobSeeker(@PathVariable String id){
        return service.deleteJobSeeker(id);
    }


}
