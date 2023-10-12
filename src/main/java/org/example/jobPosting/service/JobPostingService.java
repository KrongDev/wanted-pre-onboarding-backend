package org.example.jobPosting.service;

import lombok.RequiredArgsConstructor;
import org.example.jobPosting.aggregate.JobPosting;
import org.example.jobPosting.command.CreateJobPosting;
import org.example.jobPosting.command.UpdateJobPosting;
import org.example.jobPosting.store.JobPostingStore;
import org.example.office.aggregate.Office;
import org.example.office.service.OfficeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class JobPostingService {
    //
    private final JobPostingStore jobPostingStore;
    private final OfficeService officeService;

    public String create(CreateJobPosting command) {
        Office office = this.officeService.loadOffice(command.getOfficeId());

        String newId = UUID.randomUUID().toString();
        command.setId(newId);
        JobPosting jobPosting = new JobPosting(command);

        jobPosting.setOfficeName(office.getName());
        jobPosting.setNation(office.getNation());
        jobPosting.setRegion(office.getRegion());

        this.jobPostingStore.create(jobPosting);

        return jobPosting.getId();
    }

    public List<JobPosting> loadJobPostings(String search) {
        List<JobPosting> result = null;
        if("".equals(search)) {
            result = this.jobPostingStore.loadJobPostings();
        }else {
            result = this.jobPostingStore.loadJobPostings(search);
        }
        return result;
    }

    public void update(String jobPostingId, UpdateJobPosting command) {
        //
        JobPosting jobPosting = this.jobPostingStore.loadJobPosting(jobPostingId);
        jobPosting.update(command);

        this.jobPostingStore.update(jobPosting);
    }

    public void delete(String jobPostingId) {
        //
        this.jobPostingStore.delete(jobPostingId);
    }
}
