package org.example.jobPosting.store.orm;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostingRepository extends JpaRepository<JobPostingJpo, String> {
    //
    List<JobPostingJpo> findAllByOfficeNameContainsOrPositionContainsOrderByOfficeName(String officeName, String position);
}
