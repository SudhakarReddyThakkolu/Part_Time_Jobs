package com.sudha.PartTimeJobs.controller;

import com.sudha.PartTimeJobs.dto.JobRequestDTO;
import com.sudha.PartTimeJobs.service.JobRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-requests")
public class JobRequestController {

    private final JobRequestService jobRequestService;

    @Autowired
    public JobRequestController(JobRequestService jobRequestService) {
        this.jobRequestService = jobRequestService;
    }

    // GET all job requests
    @GetMapping
    public List<JobRequestDTO> getAllJobRequests() {
        return jobRequestService.getAllJobRequests();
    }

    // GET job request by ID
    @GetMapping("/{id}")
    public ResponseEntity<JobRequestDTO> getJobRequestById(@PathVariable Long id) {
        JobRequestDTO dto = jobRequestService.getJobRequestById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    // POST create new job request
    @PostMapping
    public ResponseEntity<JobRequestDTO> createJobRequest(@RequestBody JobRequestDTO dto) {
        JobRequestDTO created = jobRequestService.createJobRequest(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // PUT update job request
    @PutMapping("/{id}")
    public ResponseEntity<JobRequestDTO> updateJobRequest(@PathVariable Long id, @RequestBody JobRequestDTO dto) {
        JobRequestDTO updated = jobRequestService.updateJobRequest(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // DELETE job request
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobRequest(@PathVariable Long id) {
        jobRequestService.deleteJobRequest(id);
        return ResponseEntity.noContent().build();
    }
}
