package org.example.jobPost.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobPost {
    //
    transient private String id;
    private String officeId;
    private String position;
    private int compensation;
    private String content;
    private String skill;
}
