package org.example.jobPost.controller;

import lombok.RequiredArgsConstructor;
import org.example.jobPost.aggregate.JobPost;
import org.example.jobPost.command.CreateJobPost;
import org.example.jobPost.command.UpdateJobPost;
import org.example.jobPost.service.JobPostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job-post")
@RequiredArgsConstructor
public class JobPostController {
    //
    private final JobPostService jobPostService;

    @PostMapping
    public String create(@RequestBody CreateJobPost command) {
        //
        return this.jobPostService.create(command);
    }

    @GetMapping("/{jobPostId}")
    public JobPost loadjobPost(@PathVariable String jobPostId) {
        //
        return this.jobPostService.loadjobPost(jobPostId);
    }

    @GetMapping
    public List<JobPost> loadjobPosts(
            @RequestParam(defaultValue = "") String search
    ) {
        //
        return this.jobPostService.loadjobPosts(search);
    }

    @PutMapping("/{jobPostId}")
    public void update(@PathVariable String jobPostId, @RequestBody UpdateJobPost command) {
        //
        this.jobPostService.update(jobPostId, command);
    }

    @DeleteMapping("/{jobPostId}")
    public void delete(@PathVariable String jobPostId) {
        //
        this.jobPostService.delete(jobPostId);
    }
}
