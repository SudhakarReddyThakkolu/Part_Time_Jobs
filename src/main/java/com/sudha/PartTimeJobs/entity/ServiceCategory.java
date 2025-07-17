package com.sudha.PartTimeJobs.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "service_categories")
public class ServiceCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String categoryName;

    private String description;

    // One category can have many job requests
    @OneToMany(mappedBy = "serviceCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobRequest> jobRequests;
}
