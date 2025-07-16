package com.sudha.PartTimeJobs.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "job_requests")
public class JobRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many job requests can be made by a single customer
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Many job requests can target a single service provider
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_provider_id")
    private ServiceProvider serviceProvider;

    @Column(nullable = false)
    private String jobType;  // Example: "Driver", "Maid", "Plumber", etc.

    @Column(nullable = false)
    private String location;

    private LocalDateTime requestTime;

    private LocalDateTime scheduledTime;

    private String status;  // Example: "Pending", "Accepted", "Completed", "Cancelled"

    private String notes;   // Any special instructions from customer

    // Constructors
    public JobRequest() {}

    public JobRequest(Customer customer, ServiceProvider serviceProvider, String jobType,
                      String location, LocalDateTime requestTime, LocalDateTime scheduledTime,
                      String status, String notes) {
        this.customer = customer;
        this.serviceProvider = serviceProvider;
        this.jobType = jobType;
        this.location = location;
        this.requestTime = requestTime;
        this.scheduledTime = scheduledTime;
        this.status = status;
        this.notes = notes;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Customer getCustomer() { return customer; }

    public void setCustomer(Customer customer) { this.customer = customer; }

    public ServiceProvider getServiceProvider() { return serviceProvider; }

    public void setServiceProvider(ServiceProvider serviceProvider) { this.serviceProvider = serviceProvider; }

    public String getJobType() { return jobType; }

    public void setJobType(String jobType) { this.jobType = jobType; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public LocalDateTime getRequestTime() { return requestTime; }

    public void setRequestTime(LocalDateTime requestTime) { this.requestTime = requestTime; }

    public LocalDateTime getScheduledTime() { return scheduledTime; }

    public void setScheduledTime(LocalDateTime scheduledTime) { this.scheduledTime = scheduledTime; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getNotes() { return notes; }

    public void setNotes(String notes) { this.notes = notes; }
}
