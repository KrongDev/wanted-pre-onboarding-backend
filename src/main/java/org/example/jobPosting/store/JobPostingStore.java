package org.example.jobPosting.store;

import lombok.RequiredArgsConstructor;
import org.example.jobPosting.aggregate.JobPosting;
import org.example.jobPosting.store.orm.JobPostingJpo;
import org.example.jobPosting.store.orm.JobPostingRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JobPostingStore {
    //
    private final JobPostingRepository jobPostingRepository;

    public void create(JobPosting jobPosting) {
        //
        this.jobPostingRepository.save(new JobPostingJpo(jobPosting));
    }
}
