package com.sudha.PartTimeJobs.dto;

import lombok.Data;
import java.util.Set;

@Data
public class ServiceProviderDTO {
    private Long id;
    private String fullName;
    private String phone;
    private String email;
    private String city;
    private String area;
    private int experience;
    private double hourlyRate;
    private Set<String> servicesOffered;
    private boolean available;
}
