package org.example.jobPosting.store;

import lombok.RequiredArgsConstructor;
import org.example.jobPosting.aggregate.JobPosting;
import org.example.jobPosting.store.orm.JobPostingJpo;
import org.example.jobPosting.store.orm.JobPostingRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<JobPosting> loadJobPostings() {
        //
        List<JobPostingJpo> jpos = this.jobPostingRepository.findAll(Sort.by("officeName"));
        return jpos.stream().map(JobPostingJpo::toDomain).collect(Collectors.toList());
    }

    public List<JobPosting> loadJobPostings(String search) {
        //
        List<JobPostingJpo> jpos = this.jobPostingRepository.findAllByOfficeNameContainsOrPositionContainsOrderByOfficeName(search,search);
        return jpos.stream().map(JobPostingJpo::toDomain).collect(Collectors.toList());
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
