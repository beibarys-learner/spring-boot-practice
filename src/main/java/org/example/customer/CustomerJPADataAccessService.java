package org.example.customer;

import java.util.List;
import java.util.Optional;

public class CustomerJPADataAccessService implements CustomerDAO{

    private final CustomerRepository customerRepository; // injecting Customer Repo

    public CustomerJPADataAccessService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> selectAllCustomersById(Integer id) {
        return Optional.empty();
    }
}
