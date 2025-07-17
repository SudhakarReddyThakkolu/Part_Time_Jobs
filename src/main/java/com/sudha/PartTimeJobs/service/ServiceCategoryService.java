package com.sudha.PartTimeJobs.service;

import com.sudha.PartTimeJobs.dto.ServiceCategoryDTO;

import java.util.List;

public interface ServiceCategoryService {
    ServiceCategoryDTO createCategory(ServiceCategoryDTO dto);
    ServiceCategoryDTO getCategoryById(Long id);
    List<ServiceCategoryDTO> getAllCategories();
    ServiceCategoryDTO updateCategory(Long id, ServiceCategoryDTO dto);
    void deleteCategory(Long id);
}
