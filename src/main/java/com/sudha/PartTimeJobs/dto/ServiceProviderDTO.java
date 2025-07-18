package com.sudha.PartTimeJobs.dto;

import lombok.Data;
import java.util.Set;

//@Data
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Set<String> getServicesOffered() {
        return servicesOffered;
    }

    public void setServicesOffered(Set<String> servicesOffered) {
        this.servicesOffered = servicesOffered;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
