package com.sudha.PartTimeJobs.service.impl;

import com.sudha.PartTimeJobs.dto.ServiceProviderDTO;
import com.sudha.PartTimeJobs.entity.ServiceProvider;
import com.sudha.PartTimeJobs.mapper.ServiceProviderMapper;
import com.sudha.PartTimeJobs.repository.ServiceProviderRepository;
import com.sudha.PartTimeJobs.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

    @Autowired
    private ServiceProviderRepository providerRepository;

    @Override
    public ServiceProviderDTO createProvider(ServiceProviderDTO providerDTO) {
        ServiceProvider provider = ServiceProviderMapper.toEntity(providerDTO);
        ServiceProvider saved = providerRepository.save(provider);
        return ServiceProviderMapper.toDTO(saved);
    }

    @Override
    public ServiceProviderDTO getProviderById(Long id) {
        return providerRepository.findById(id)
                .map(ServiceProviderMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<ServiceProviderDTO> getAllProviders() {
        return providerRepository.findAll()
                .stream()
                .map(ServiceProviderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ServiceProviderDTO updateProvider(Long id, ServiceProviderDTO providerDTO) {
        return providerRepository.findById(id).map(existing -> {
            existing.setFullName(providerDTO.getFullName());
            existing.setAvailable(providerDTO.isAvailable());
            existing.setServicesOffered(Set.of(String.valueOf(providerDTO.getExperience())));
            return ServiceProviderMapper.toDTO(providerRepository.save(existing));
        }).orElse(null);
    }

    @Override
    public void deleteProvider(Long id) {
        providerRepository.deleteById(id);
    }
}
