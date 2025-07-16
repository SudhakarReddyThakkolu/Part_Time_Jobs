package com.sudha.PartTimeJobs.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service_providers")
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(nullable = false, unique = true)
    private String phone;

    private String email;

    private String city;

    private String area;

    private int experience; // in years

    private double hourlyRate;

    @ElementCollection
    @CollectionTable(name = "provider_services", joinColumns = @JoinColumn(name = "provider_id"))
    @Column(name = "service_type")
    private Set<String> servicesOffered;

    private boolean available;

    // Constructors
    public ServiceProvider() {}

    public ServiceProvider(String fullName, String phone, String email, String city, String area,
                           int experience, double hourlyRate, Set<String> servicesOffered, boolean available) {
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.area = area;
        this.experience = experience;
        this.hourlyRate = hourlyRate;
        this.servicesOffered = servicesOffered;
        this.available = available;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }

    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getArea() { return area; }

    public void setArea(String area) { this.area = area; }

    public int getExperience() { return experience; }

    public void setExperience(int experience) { this.experience = experience; }

    public double getHourlyRate() { return hourlyRate; }

    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }

    public Set<String> getServicesOffered() { return servicesOffered; }

    public void setServicesOffered(Set<String> servicesOffered) { this.servicesOffered = servicesOffered; }

    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) { this.available = available; }
}
