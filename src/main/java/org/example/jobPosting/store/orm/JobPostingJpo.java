package org.example.jobPosting.store.orm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.jobPosting.aggregate.JobPosting;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_job_posting")
public class JobPostingJpo {
    //
    @Id
    private String id;
    // office data
    private String officeId;
    private String officeName;
    private String nation;
    private String region;

    //posting data
    private String position;
    private int compensation;
    private String content;
    private String skill;

    public JobPostingJpo (JobPosting jobPosting) {
        BeanUtils.copyProperties(jobPosting, this);
    }

    public JobPosting toDomain() {
        JobPosting jobPosting = new JobPosting();
        BeanUtils.copyProperties(this, jobPosting);
        return jobPosting;
    }
}
