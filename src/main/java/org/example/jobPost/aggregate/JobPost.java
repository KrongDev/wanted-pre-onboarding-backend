package org.example.jobPost.aggregate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.jobPost.command.CreateJobPost;
import org.example.jobPost.command.UpdateJobPost;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class JobPost {
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

    private List<String> officePostIds;

    public JobPost() {
        this.officeName = "";
        this.nation = "";
        this.region = "";
        this.officePostIds = new ArrayList<>();
    }

    public JobPost(CreateJobPost command) {
        //
        BeanUtils.copyProperties(command, this);
    }

    public void update(UpdateJobPost command) {
        //
        this.position = command.getPosition();
        this.compensation = command.getCompensation();
        this.content = command.getContent();
        this.skill = command.getSkill();
    }
}
