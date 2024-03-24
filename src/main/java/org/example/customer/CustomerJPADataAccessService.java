package org.example.customer;

import java.util.List;
import java.util.Optional;

public class CustomerJPADataAccessService implements CustomerDAO{
    @Override
    public List<Customer> selectAllCustomers() {
        return null;
    }

    @Override
    public Optional<Customer> selectAllCustomersById(Integer id) {
        return Optional.empty();
    }
}
