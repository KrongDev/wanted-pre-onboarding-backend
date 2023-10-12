package org.example.jobPost.store.orm;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostRepository extends JpaRepository<JobPostJpo, String> {
    //
    List<JobPostJpo> findAllByOfficeNameContainsOrPositionContainsOrderByOfficeName(String officeName, String position);
}
