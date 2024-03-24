package org.example.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("list")
public class CustomerListDataAccessService implements CustomerDAO {
    private static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        Customer james = new Customer(
                "James", "java@gmail.com", 68
        );
        customers.add(james);

        Customer guido = new Customer(
                "Guido", "python@gmail.com", 67
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
