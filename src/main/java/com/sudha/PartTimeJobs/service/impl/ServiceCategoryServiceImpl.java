package com.sudha.PartTimeJobs.service.impl;

import com.sudha.PartTimeJobs.dto.ServiceCategoryDTO;
import com.sudha.PartTimeJobs.entity.ServiceCategory;
import com.sudha.PartTimeJobs.mapper.ServiceCategoryMapper;
import com.sudha.PartTimeJobs.repository.ServiceCategoryRepository;
import com.sudha.PartTimeJobs.service.ServiceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceCategoryServiceImpl implements ServiceCategoryService {

    @Autowired
    private ServiceCategoryRepository categoryRepository;

    @Autowired
    private ServiceCategoryMapper categoryMapper;

    @Override
    public ServiceCategoryDTO createCategory(ServiceCategoryDTO dto) {
        ServiceCategory category = categoryMapper.toEntity(dto);
        ServiceCategory saved = categoryRepository.save(category);
        return categoryMapper.toDTO(saved);
    }

    @Override
    public ServiceCategoryDTO getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<ServiceCategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ServiceCategoryDTO updateCategory(Long id, ServiceCategoryDTO dto) {
        return categoryRepository.findById(id).map(existing -> {
            existing.setCategoryName(dto.getCategoryName());
            existing.setDescription(dto.getDescription());
            ServiceCategory updated = categoryRepository.save(existing);
            return categoryMapper.toDTO(updated);
        }).orElse(null);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
