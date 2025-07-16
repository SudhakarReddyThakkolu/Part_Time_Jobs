package com.sudha.PartTimeJobs.mapper;

import com.sudha.PartTimeJobs.dto.CustomerDTO;
import com.sudha.PartTimeJobs.entity.Customer;

public class CustomerMapper {

    public static CustomerDTO toDTO(Customer customer) {
        if (customer == null) return null;

        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setFullName(customer.getFullName());
        dto.setPhone(customer.getPhone());
        dto.setEmail(customer.getEmail());
        dto.setCity(customer.getCity());
        dto.setArea(customer.getArea());
        dto.setAddress(customer.getAddress());
        dto.setActive(customer.isActive());
        return dto;
    }

    public static Customer toEntity(CustomerDTO dto) {
        if (dto == null) return null;

        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setFullName(dto.getFullName());
        customer.setPhone(dto.getPhone());
        customer.setEmail(dto.getEmail());
        customer.setCity(dto.getCity());
        customer.setArea(dto.getArea());
        customer.setAddress(dto.getAddress());
        customer.setActive(dto.isActive());
        return customer;
    }
}
