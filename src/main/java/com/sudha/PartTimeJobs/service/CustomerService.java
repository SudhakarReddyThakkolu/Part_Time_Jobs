package com.sudha.PartTimeJobs.service;

import com.sudha.PartTimeJobs.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    CustomerDTO getCustomerById(Long id);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);
    void deleteCustomer(Long id);
}
