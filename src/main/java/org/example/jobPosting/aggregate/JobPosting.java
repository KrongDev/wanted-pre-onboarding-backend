package org.example.jobPosting.aggregate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.jobPosting.command.CreateJobPosting;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
public class JobPosting {
    //
    private String id;

    private String officeId;
    private String officeName;
    private String nation;
    private String region;

    private String position;
    private int compensation;
    private String content;
    private String skill;

    public JobPosting() {
        this.officeName = "";
        this.nation = "";
        this.region = "";
    }

    public JobPosting (CreateJobPosting command) {
        //
        BeanUtils.copyProperties(command, this);
    }
}