package com.sudha.PartTimeJobs.service.impl;

import com.sudha.PartTimeJobs.dto.CustomerDTO;
import com.sudha.PartTimeJobs.entity.Customer;
import com.sudha.PartTimeJobs.mapper.CustomerMapper;
import com.sudha.PartTimeJobs.repository.CustomerRepository;
import com.sudha.PartTimeJobs.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.toEntity(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.toDTO(savedCustomer);
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(CustomerMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(CustomerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        return customerRepository.findById(id).map(existing -> {
            existing.setFullName(customerDTO.getFullName());
            existing.setPhone(customerDTO.getPhone());
            return CustomerMapper.toDTO(customerRepository.save(existing));
        }).orElse(null);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
