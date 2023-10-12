package org.example.jobPost.aggregate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class OfficePostMap {
    //
    private String officeId;
    private List<String> jobPostIds;

    public OfficePostMap() {
        //
        this.jobPostIds = new ArrayList<>();
    }

    public OfficePostMap(String officeId) {
        //
        this();
        this.officeId = officeId;
    }

    public void add(String jobPostId) {
        //
        this.jobPostIds.add(jobPostId);
    }

    public void remove(String jobPostId) {
        //
        if(Objects.isNull(this.jobPostIds) || this.jobPostIds.isEmpty()) return;

        this.jobPostIds = this.jobPostIds.stream().filter(id -> !jobPostId.equals(id)).collect(Collectors.toList());
    }
}
