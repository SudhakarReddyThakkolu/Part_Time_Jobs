package com.sudha.PartTimeJobs.service;

import com.sudha.PartTimeJobs.dto.JobRequestDTO;

import java.util.List;

public interface JobRequestService {

    JobRequestDTO createJobRequest(JobRequestDTO dto);

    JobRequestDTO getJobRequestById(Long id);

    List<JobRequestDTO> getAllJobRequests();

    JobRequestDTO updateJobRequest(Long id, JobRequestDTO dto);

    void deleteJobRequest(Long id);
}
