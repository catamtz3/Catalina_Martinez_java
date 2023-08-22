package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository repo;

    // Create a new customer record
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) {
        return repo.save(customer);
    }

    // Update an existing customer record
    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAlbum(@RequestBody Customer customer) {
        repo.save(customer);
    }

    // Delete an existing customer record
    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbum(@PathVariable int id) {
        repo.deleteById(id);
    }

    // Find a customer record by ID
    @GetMapping("/customers/{id}")
    public Customer getCustomerbyID(@PathVariable int id) {
        Optional<Customer> returnVal = repo.findById(id);
        if(returnVal.isPresent()){
            return returnVal.get();
        }
        return null;
    }

    // Find customer records by state
    @GetMapping("/customers/state/{state}")
    public List<Customer> getCustomerbyState(@PathVariable String state) {
        return repo.findByState(state);
    }

}