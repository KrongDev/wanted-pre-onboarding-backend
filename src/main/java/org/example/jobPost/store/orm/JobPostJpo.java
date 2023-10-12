package org.example.jobPost.store.orm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.jobPost.aggregate.JobPost;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_job_post")
public class JobPostJpo {
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

    public JobPostJpo(JobPost jobPost) {
        BeanUtils.copyProperties(jobPost, this);
    }

    public JobPost toDomain() {
        JobPost jobPost = new JobPost();
        BeanUtils.copyProperties(this, jobPost);
        return jobPost;
    }
}
