package com.sudha.PartTimeJobs.mapper;

import com.sudha.PartTimeJobs.dto.ServiceCategoryDTO;
import com.sudha.PartTimeJobs.entity.ServiceCategory;
import org.springframework.stereotype.Component;

@Component
public class ServiceCategoryMapper {

    public ServiceCategoryDTO toDTO(ServiceCategory category) {
        if (category == null) return null;

        ServiceCategoryDTO dto = new ServiceCategoryDTO();
        dto.setId(category.getId());
        dto.setCategoryName(category.getCategoryName());
        dto.setDescription(category.getDescription());

        return dto;
    }

    public ServiceCategory toEntity(ServiceCategoryDTO dto) {
        if (dto == null) return null;

        ServiceCategory category = new ServiceCategory();
        category.setId(dto.getId());
        category.setCategoryName(dto.getCategoryName());
        category.setDescription(dto.getDescription());

        return category;
    }
}
