package com.sudha.PartTimeJobs.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JobRequestDTO {
    private Long id;
    private Long customerId;
    private Long serviceProviderId;
    private Long categoryId;
    private String description;
    private String status;
    private LocalDateTime requestTime;
    private LocalDateTime scheduledTime;
    private String location;
    private String notes;
}
