package com.sudha.PartTimeJobs.controller;

import com.sudha.PartTimeJobs.dto.ServiceProviderDTO;
import com.sudha.PartTimeJobs.service.ServiceProviderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Service Providers", description = "Manage service provider registrations and details")
@RestController
@RequestMapping("/api/service-providers")
public class ServiceProviderController {

    private final ServiceProviderService serviceProviderService;

    @Autowired
    public ServiceProviderController(ServiceProviderService serviceProviderService) {
        this.serviceProviderService = serviceProviderService;
    }

    // GET all service providers
    @Operation(summary = "Get all service providers")
    @GetMapping
    public List<ServiceProviderDTO> getAllServiceProviders() {
        return serviceProviderService.getAllProviders();
    }

    // GET service provider by ID
    @Operation(summary = "Get service provider by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ServiceProviderDTO> getServiceProviderById(@PathVariable Long id) {
        ServiceProviderDTO dto = serviceProviderService.getProviderById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    // POST create new service provider
    @Operation(summary = "Create a new service provider")
    @PostMapping
    public ResponseEntity<ServiceProviderDTO> createServiceProvider(@RequestBody ServiceProviderDTO dto) {
        ServiceProviderDTO created = serviceProviderService.createProvider(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // PUT update service provider
    @Operation(summary = "Update service provider details")
    @PutMapping("/{id}")
    public ResponseEntity<ServiceProviderDTO> updateServiceProvider(@PathVariable Long id, @RequestBody ServiceProviderDTO dto) {
        ServiceProviderDTO updated = serviceProviderService.updateProvider(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // DELETE service provider
    @Operation(summary = "Delete service provider by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceProvider(@PathVariable Long id) {
        serviceProviderService.deleteProvider(id);
        return ResponseEntity.noContent().build();
    }
}
