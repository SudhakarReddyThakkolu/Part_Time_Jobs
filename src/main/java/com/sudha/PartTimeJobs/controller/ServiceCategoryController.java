package com.sudha.PartTimeJobs.controller;

import com.sudha.PartTimeJobs.dto.ServiceCategoryDTO;
import com.sudha.PartTimeJobs.service.ServiceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-categories")
public class ServiceCategoryController {

    private final ServiceCategoryService serviceCategoryService;

    @Autowired
    public ServiceCategoryController(ServiceCategoryService serviceCategoryService) {
        this.serviceCategoryService = serviceCategoryService;
    }

    // GET all service categories
    @GetMapping
    public List<ServiceCategoryDTO> getAllServiceCategories() {
        return serviceCategoryService.getAllCategories();
    }

    // GET service category by ID
    @GetMapping("/{id}")
    public ResponseEntity<ServiceCategoryDTO> getServiceCategoryById(@PathVariable Long id) {
        ServiceCategoryDTO dto = serviceCategoryService.getCategoryById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    // POST create new service category
    @PostMapping
    public ResponseEntity<ServiceCategoryDTO> createServiceCategory(@RequestBody ServiceCategoryDTO dto) {
        ServiceCategoryDTO created = serviceCategoryService.createCategory(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // PUT update service category
    @PutMapping("/{id}")
    public ResponseEntity<ServiceCategoryDTO> updateServiceCategory(@PathVariable Long id, @RequestBody ServiceCategoryDTO dto) {
        ServiceCategoryDTO updated = serviceCategoryService.updateCategory(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // DELETE service category
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceCategory(@PathVariable Long id) {
        serviceCategoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
