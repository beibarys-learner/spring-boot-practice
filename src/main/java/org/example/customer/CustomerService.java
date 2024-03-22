package org.example.customer;

import java.util.List;

public class CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<Customer> getAllCustomers(){
        return customerDAO.selectAllCustomers();
    }

    public Customer getCustomer(Integer id){
        return customerDAO.selectAllCustomersById(id).
                orElseThrow(() -> new IllegalArgumentException(
                                "customer with id [%s} not found".formatted(id)
                        ));
    }
}
