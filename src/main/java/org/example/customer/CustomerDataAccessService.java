package org.example.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDataAccessService implements CustomerDAO {
    private static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        Customer james = new Customer(
                1, "James", "java@gmail.com", 68
        );
        customers.add(james);

        Customer guido = new Customer(
                2, "Guido", "python@gmail.com", 67
        );
        customers.add(guido);

    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectAllCustomersById(Integer id) {
        return customers.stream().
                filter(c -> c.getId().equals(id))
                .findFirst();

    }
}
