package org.example.jobPosting.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateJobPosting {
    //
    private String position;
    private int compensation;
    private String content;
    private String skill;
}
