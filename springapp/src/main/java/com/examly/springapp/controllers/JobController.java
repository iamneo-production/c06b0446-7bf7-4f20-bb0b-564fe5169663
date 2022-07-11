package com.example.controllers;

import com.example.dto.jobDTO;
import com.example.models.Job;
import com.example.security.services.JobService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

@RequestMapping("/admin")
public class JobController {
    @Autowired
    private JobService service;

    @PostMapping("/addJob")
    public Job saveJob(@RequestBody jobDTO jdto){
        return service.saveJob(jdto);
    }


    @PostMapping("/editJob/{id}")
    public Job updatejob(@RequestBody jobDTO jobDTO, @PathVariable String id){
        return service.updateJob(jobDTO,id);
    }



    @GetMapping("/getAlljobs")
    public List<Job>  getJobs(){
        return service.getJobs();
    }





    @DeleteMapping("/deleteJob/{id}")
    public String deleteJob(@PathVariable String id){
        return service.deleteJob(id);
    }


}
