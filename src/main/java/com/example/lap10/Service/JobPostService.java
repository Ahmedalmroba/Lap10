package com.example.lap10.Service;

import com.example.lap10.Model.JobPost;
import com.example.lap10.Repository.JobPostRepository;
import com.example.lap10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {
    private final JobPostRepository jobPostRepository;

    public List<JobPost> getAllJobPosts(){
        return jobPostRepository.findAll();
    }
    public void addJobPosts(JobPost jobPost ){
        jobPostRepository.save(jobPost);
    }
    public boolean updateJobPost(Integer id,JobPost jobPost){
        JobPost j = jobPostRepository.findById(id).get();
        if(j == null){
            return false;
        }
        j.setTitle(jobPost.getTitle());
        j.setDescription(jobPost.getDescription());
        j.setLocation(jobPost.getLocation());
        j.setSalary(jobPost.getSalary());
        j.setPostingDate(j.getPostingDate());
        jobPostRepository.save(j);
        return true;
    }
    public boolean deleteJobPost(Integer id){
        JobPost j = jobPostRepository.findById(id).get();
        if(j == null){
            return false;

        }
        jobPostRepository.delete(j);
        return true;
    }
}
