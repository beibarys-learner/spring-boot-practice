package org.example.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    //    @RequestMapping(path = "api/v1/customer" method = RequestMethod.GET) same as GetMapping
    @GetMapping("api/v1/customers")
    public List<Customer> getCustomers(){
        return customers;
    }


    // write a second endpoint so we will return customer by ID
    @GetMapping("api/v1/customers/{customerId}")
    public Customer getCustomers(
            @PathVariable("customerId") Integer customerId){
        return customer;
    }
}
