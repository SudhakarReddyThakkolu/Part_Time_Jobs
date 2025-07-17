package com.sudha.PartTimeJobs.service.impl;

import com.sudha.PartTimeJobs.dto.JobRequestDTO;
import com.sudha.PartTimeJobs.entity.Customer;
import com.sudha.PartTimeJobs.entity.JobRequest;
import com.sudha.PartTimeJobs.entity.ServiceCategory;
import com.sudha.PartTimeJobs.entity.ServiceProvider;
import com.sudha.PartTimeJobs.mapper.JobRequestMapper;
import com.sudha.PartTimeJobs.repository.CustomerRepository;
import com.sudha.PartTimeJobs.repository.JobRequestRepository;
import com.sudha.PartTimeJobs.repository.ServiceCategoryRepository;
import com.sudha.PartTimeJobs.repository.ServiceProviderRepository;
import com.sudha.PartTimeJobs.service.JobRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobRequestServiceImpl implements JobRequestService {

    @Autowired
    private JobRequestRepository jobRequestRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    @Autowired
    private ServiceCategoryRepository serviceCategoryRepository;

    @Autowired
    private JobRequestMapper jobRequestMapper;

    @Override
    public JobRequestDTO createJobRequest(JobRequestDTO dto) {
        Optional<Customer> customerOpt = customerRepository.findById(dto.getCustomerId());
        Optional<ServiceProvider> providerOpt = serviceProviderRepository.findById(dto.getServiceProviderId());
        Optional<ServiceCategory> categoryOpt = serviceCategoryRepository.findById(dto.getCategoryId());

        if (customerOpt.isEmpty() || providerOpt.isEmpty() || categoryOpt.isEmpty()) {
            throw new RuntimeException("Invalid IDs provided for Customer, Provider or Category.");
        }

        JobRequest job = JobRequestMapper.toEntity(dto, customerOpt.get(), providerOpt.get(), categoryOpt.get());
        JobRequest saved = jobRequestRepository.save(job);
        return JobRequestMapper.toDTO(saved);
    }

    @Override
    public JobRequestDTO getJobRequestById(Long id) {
        return jobRequestRepository.findById(id)
                .map(JobRequestMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<JobRequestDTO> getAllJobRequests() {
        return jobRequestRepository.findAll()
                .stream()
                .map(JobRequestMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public JobRequestDTO updateJobRequest(Long id, JobRequestDTO dto) {
        return jobRequestRepository.findById(id).map(existing -> {
            existing.setStatus(dto.getStatus());
            existing.setDescription(dto.getDescription());
            existing.setRequestTime(dto.getRequestTime());
            JobRequest updated = jobRequestRepository.save(existing);
            return JobRequestMapper.toDTO(updated);
        }).orElse(null);
    }

    @Override
    public void deleteJobRequest(Long id) {
        jobRequestRepository.deleteById(id);
    }
}
