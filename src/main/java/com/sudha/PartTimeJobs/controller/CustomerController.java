package com.sudha.PartTimeJobs.controller;

import com.sudha.PartTimeJobs.dto.CustomerDTO;
import com.sudha.PartTimeJobs.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Customers", description = "Manage customer accounts and profiles")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // GET all customers
    @Operation(summary = "Get all customers")
    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // GET customer by ID
    @Operation(summary = "Get customer by ID")
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        CustomerDTO dto = customerService.getCustomerById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    // POST create new customer
    @Operation(summary = "Create a new customer")
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO dto) {
        CustomerDTO created = customerService.createCustomer(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // PUT update customer
    @Operation(summary = "Update customer details")
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO dto) {
        CustomerDTO updated = customerService.updateCustomer(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // DELETE customer
    @Operation(summary = "Delete customer by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
