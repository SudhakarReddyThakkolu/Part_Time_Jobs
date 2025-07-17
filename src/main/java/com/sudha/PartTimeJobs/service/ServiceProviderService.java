package com.sudha.PartTimeJobs.service;

import com.sudha.PartTimeJobs.dto.ServiceProviderDTO;

import java.util.List;

public interface ServiceProviderService {
    ServiceProviderDTO createProvider(ServiceProviderDTO providerDTO);
    ServiceProviderDTO getProviderById(Long id);
    List<ServiceProviderDTO> getAllProviders();
    ServiceProviderDTO updateProvider(Long id, ServiceProviderDTO providerDTO);
    void deleteProvider(Long id);
}
