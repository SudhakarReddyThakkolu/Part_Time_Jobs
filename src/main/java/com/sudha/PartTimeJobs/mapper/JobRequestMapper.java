package com.sudha.PartTimeJobs.mapper;

import com.sudha.PartTimeJobs.dto.JobRequestDTO;
import com.sudha.PartTimeJobs.entity.*;

public class JobRequestMapper {

    public static JobRequestDTO toDTO(JobRequest job) {
        if (job == null) return null;

        JobRequestDTO dto = new JobRequestDTO();
        dto.setId(job.getId());
        dto.setCustomerId(job.getCustomer().getId());
        dto.setServiceProviderId(job.getServiceProvider().getId());
        dto.setCategoryId(job.getServiceCategory().getId());
        dto.setDescription(job.getDescription());
        dto.setStatus(job.getStatus());
        dto.setRequestTime(job.getRequestTime());
        dto.setScheduledTime(job.getScheduledTime());
        dto.setLocation(job.getLocation());
        dto.setNotes(job.getNotes());
        return dto;
    }

    public static JobRequest toEntity(JobRequestDTO dto, Customer customer, ServiceProvider provider, ServiceCategory category) {
        if (dto == null) return null;

        JobRequest job = new JobRequest();
        job.setId(dto.getId());
        job.setCustomer(customer);
        job.setServiceProvider(provider);
        job.setServiceCategory(category);
        job.setDescription(dto.getDescription());
        job.setStatus(dto.getStatus());
        job.setRequestTime(dto.getRequestTime());
        job.setScheduledTime(dto.getScheduledTime());
        job.setLocation(dto.getLocation());
        job.setNotes(dto.getNotes());
        return job;
    }
}
