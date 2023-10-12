package org.example.jobPosting.controller;

import lombok.RequiredArgsConstructor;
import org.example.jobPosting.aggregate.JobPosting;
import org.example.jobPosting.command.CreateJobPosting;
import org.example.jobPosting.command.UpdateJobPosting;
import org.example.jobPosting.service.JobPostingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job-posting")
@RequiredArgsConstructor
public class JobPostingController {
    //
    private final JobPostingService jobPostingService;

    @PostMapping
    public String create(@RequestBody CreateJobPosting command) {
        //
        return this.jobPostingService.create(command);
    }

    @GetMapping
    public List<JobPosting> loadJobPostings(
            @RequestParam(defaultValue = "") String search
    ) {
        //
        return this.jobPostingService.loadJobPostings(search);
    }

    @PutMapping("/{jobPostingId}")
    public void update(@PathVariable String jobPostingId, @RequestBody UpdateJobPosting command) {
        //
        this.jobPostingService.update(jobPostingId, command);
    }

    @DeleteMapping("/{jobPostingId}")
    public void delete(@PathVariable String jobPostingId) {
        //
        this.jobPostingService.delete(jobPostingId);
    }
}
