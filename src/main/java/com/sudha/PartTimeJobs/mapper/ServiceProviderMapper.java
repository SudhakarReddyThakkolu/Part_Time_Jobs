package com.sudha.PartTimeJobs.mapper;

import com.sudha.PartTimeJobs.dto.ServiceProviderDTO;
import com.sudha.PartTimeJobs.entity.ServiceProvider;

public class ServiceProviderMapper {

    public static ServiceProviderDTO toDTO(ServiceProvider provider) {
        if (provider == null) return null;

        ServiceProviderDTO dto = new ServiceProviderDTO();
        dto.setId(provider.getId());
        dto.setFullName(provider.getFullName());
        dto.setPhone(provider.getPhone());
        dto.setEmail(provider.getEmail());
        dto.setCity(provider.getCity());
        dto.setArea(provider.getArea());
        dto.setExperience(provider.getExperience());
        dto.setHourlyRate(provider.getHourlyRate());
        dto.setServicesOffered(provider.getServicesOffered());
        dto.setAvailable(provider.isAvailable());
        return dto;
    }

    public static ServiceProvider toEntity(ServiceProviderDTO dto) {
        if (dto == null) return null;

        ServiceProvider provider = new ServiceProvider();
        provider.setId(dto.getId());
        provider.setFullName(dto.getFullName());
        provider.setPhone(dto.getPhone());
        provider.setEmail(dto.getEmail());
        provider.setCity(dto.getCity());
        provider.setArea(dto.getArea());
        provider.setExperience(dto.getExperience());
        provider.setHourlyRate(dto.getHourlyRate());
        provider.setServicesOffered(dto.getServicesOffered());
        provider.setAvailable(dto.isAvailable());
        return provider;
    }
}
