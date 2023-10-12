package org.example.jobPost.store;

import lombok.RequiredArgsConstructor;
import org.example.jobPost.aggregate.JobPost;
import org.example.jobPost.store.orm.JobPostJpo;
import org.example.jobPost.store.orm.JobPostRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class JobPostStore {
    //
    private final JobPostRepository jobPostRepository;

    public void create(JobPost jobPost) {
        //
        this.jobPostRepository.save(new JobPostJpo(jobPost));
    }

    public JobPost loadJobPost(String jobPostId) {
        //
        Optional<JobPostJpo> jpo = this.jobPostRepository.findById(jobPostId);
        if(jpo.isEmpty()) throw new NoSuchElementException();
        return jpo.get().toDomain();
    }

    public List<JobPost> loadJobPosts() {
        //
        List<JobPostJpo> jpos = this.jobPostRepository.findAll(Sort.by("officeName"));
        return jpos.stream().map(JobPostJpo::toDomain).collect(Collectors.toList());
    }

    public List<JobPost> loadJobPosts(String search) {
        //
        List<JobPostJpo> jpos = this.jobPostRepository.findAllByOfficeNameContainsOrPositionContainsOrderByOfficeName(search,search);
        return jpos.stream().map(JobPostJpo::toDomain).collect(Collectors.toList());
    }

    public void update(JobPost jobPost) {
        //
        this.jobPostRepository.save(new JobPostJpo(jobPost));
    }

    public void delete(String jobPostId) {
        //
        this.jobPostRepository.deleteById(jobPostId);
    }
}
