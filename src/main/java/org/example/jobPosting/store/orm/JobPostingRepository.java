package org.example.jobPosting.store.orm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingRepository extends JpaRepository<JobPostingJpo, String> {
}
