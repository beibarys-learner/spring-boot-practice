package org.example.customer;

import java.util.ArrayList;
import java.util.List;

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
}
