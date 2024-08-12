package com.example.lap10.Controller;

import com.example.lap10.Model.JobApplication;
import com.example.lap10.Service.JobApplicationService;
import com.example.lap10.Service.JobPostService;
import com.example.lap10.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/JobApplication")
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;

    @GetMapping("/get")
    public ResponseEntity GetJobApplication() {
        return ResponseEntity.status(200).body(jobApplicationService.getAllJobApplications());
    }

    @PostMapping("/apply")
    public ResponseEntity ApplyJobApplication(@Valid @RequestBody JobApplication jobApplication, Errors errors) {
        if (errors.hasErrors()) {
            String Message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(Message);
        }
        String S = jobApplicationService.ApplyForJob(jobApplication);
        if (S.equalsIgnoreCase("Apply successful")){
            return ResponseEntity.status(200).body("Apply successful");
        }
        return ResponseEntity.status(400).body("Apply successful");


    }

    @DeleteMapping("/withdraw/{id}")
    public ResponseEntity WithdrawJobApplication(@PathVariable Integer id) {
        if (jobApplicationService.Withdraw(id)){

            return ResponseEntity.status(200).body("Withdraw successful");
        }
        return ResponseEntity.status(400).body("Withdraw successful");

    }


}
