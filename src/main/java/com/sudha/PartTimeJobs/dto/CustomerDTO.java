package com.sudha.PartTimeJobs.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String fullName;
    private String phone;
    private String email;
    private String city;
    private String area;
    private String address;
    private boolean active;
}
