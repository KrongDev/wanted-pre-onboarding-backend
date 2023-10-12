package org.example.jobPosting.store;

import lombok.RequiredArgsConstructor;
import org.example.jobPosting.aggregate.JobPosting;
import org.example.jobPosting.store.orm.JobPostingJpo;
import org.example.jobPosting.store.orm.JobPostingRepository;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JobPostingStore {
    //
    private final JobPostingRepository jobPostingRepository;

    public void create(JobPosting jobPosting) {
        //
        this.jobPostingRepository.save(new JobPostingJpo(jobPosting));
    }

    public JobPosting loadJobPosting(String jobPostingId) {
        //
        Optional<JobPostingJpo> jpo = this.jobPostingRepository.findById(jobPostingId);
        if(jpo.isEmpty()) throw new NoSuchElementException();
        return jpo.get().toDomain();
    }

    public void update(JobPosting jobPosting) {
        //
        this.jobPostingRepository.save(new JobPostingJpo(jobPosting));
    }

    public void delete(String jobPostingId) {
        //
        this.jobPostingRepository.deleteById(jobPostingId);
    }
}
