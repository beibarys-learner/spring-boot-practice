package org.example.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {

    List<Customer> selectAllCustomers();
    Optional<Customer> selectAllCustomersById(Integer id);
    void insertCustomer(Customer customer);
    boolean existsPersonWithEmail(String email);
}
