package com.sudha.PartTimeJobs.repository;

import com.sudha.PartTimeJobs.entity.JobRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRequestRepository extends JpaRepository<JobRequest, Long> {
}
