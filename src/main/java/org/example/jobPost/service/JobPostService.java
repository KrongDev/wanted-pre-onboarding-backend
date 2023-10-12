package org.example.jobPost.service;

import lombok.RequiredArgsConstructor;
import org.example.jobPost.aggregate.JobPost;
import org.example.jobPost.command.CreateJobPost;
import org.example.jobPost.command.UpdateJobPost;
import org.example.jobPost.store.JobPostStore;
import org.example.office.aggregate.Office;
import org.example.office.service.OfficeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class JobPostService {
    //
    private final JobPostStore jobPostStore;
    private final OfficeService officeService;

    public String create(CreateJobPost command) {
        Office office = this.officeService.loadOffice(command.getOfficeId());

        String newId = UUID.randomUUID().toString();
        command.setId(newId);
        JobPost jobPost = new JobPost(command);

        jobPost.setOfficeName(office.getName());
        jobPost.setNation(office.getNation());
        jobPost.setRegion(office.getRegion());

        this.jobPostStore.create(jobPost);

        return jobPost.getId();
    }

    public JobPost loadjobPost(String jobPostId) {
        //
        JobPost jobPost = this.jobPostStore.loadJobPost(jobPostId);
        return jobPost;
    }

    public List<JobPost> loadjobPosts(String search) {
        List<JobPost> result = null;
        if("".equals(search)) {
            result = this.jobPostStore.loadJobPosts();
        }else {
            result = this.jobPostStore.loadJobPosts(search);
        }
        return result;
    }

    public void update(String jobPostId, UpdateJobPost command) {
        //
        JobPost jobPost = this.jobPostStore.loadJobPost(jobPostId);
        jobPost.update(command);

        this.jobPostStore.update(jobPost);
    }

    public void delete(String jobPostId) {
        //
        this.jobPostStore.delete(jobPostId);
    }
}
