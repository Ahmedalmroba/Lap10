package com.example.lap10.Service;

import com.example.lap10.Model.JobApplication;
import com.example.lap10.Model.JobPost;
import com.example.lap10.Repository.JobApplicationRepository;
import com.example.lap10.Repository.JobPostRepository;
import com.example.lap10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;
    private final JobPostRepository jobPostRepository;
    private  final UserRepository userRepository;
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }
    public String ApplyForJob (JobApplication jobApplication ) {
        if (!userRepository.existsById(jobApplication.getUserId())) {
            return "User not found";
        }
        if (!jobPostRepository.existsById(jobApplication.getJobPostId())) {
            return "JobPost not found";
        }
        jobApplicationRepository.save(jobApplication);
        return "Apply successful";
    }
    public boolean Withdraw (Integer id){
      JobApplication j =   jobApplicationRepository.getById(id);
      if (j == null){
          return false;
      }
        jobApplicationRepository.delete(j);
      return true;

    }
}
