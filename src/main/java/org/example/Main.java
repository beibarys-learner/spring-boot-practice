package org.example;

import org.example.customer.CustomerController;
import org.example.customer.CustomerDataAccessService;
import org.example.customer.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    //databases

    public static void main(String[] args) {

        /*
        never do this for instantiating these classes
        CustomerService customerService = new CustomerService(new CustomerDataAccessService());
        CustomerController customerController = new CustomerController(customerService);
        */

        SpringApplication.run(Main.class, args);
    }
}
