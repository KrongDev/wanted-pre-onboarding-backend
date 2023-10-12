package org.example.jobPosting.controller;

import lombok.RequiredArgsConstructor;
import org.example.jobPosting.command.CreateJobPosting;
import org.example.jobPosting.service.JobPostingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job-posting")
@RequiredArgsConstructor
public class JobPostingController {
    //
    private final JobPostingService jobPostingService;

    @PostMapping
    public String create(CreateJobPosting command) {
        //
        return this.jobPostingService.create(command);
    }
}
