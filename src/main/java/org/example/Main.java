package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController

public class Main {

    //databases

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

//    @RequestMapping(path = "api/v1/customer" method = RequestMethod.GET) same as GetMapping
    @GetMapping("api/v1/customers")
    public List<Customer> getCustomers(){
        return customers;
    }


    // write a second endpoint so we will return customer by ID
    @GetMapping("api/v1/customers/{customerId}")
    public Customer getCustomers(
            @PathVariable("customerId") Integer customerId){
        Customer customer = customers.stream().
                filter(c -> c.id.equals(customerId))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("customer with id [$s] not found".formatted(customerId))
                );
        return customer;
    }


}
