package org.example.customer;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //    @RequestMapping(path = "api/v1/customer" method = RequestMethod.GET) same as GetMapping
    @GetMapping
    public CustomerService getCustomers(){
        return customerService;
    }


    // write a second endpoint so we will return customer by ID
    @GetMapping("/{customerId}")
    public Customer getCustomers(
            @PathVariable("customerId") Integer customerId){
        return customerService.getCustomer(customerId);
    }

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest request){
        customerService.addCustomer(request);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer customerId){
        customerService.deleteCustomerByID(customerId);
    }

    @PutMapping("/{customerId}")
    public void deleteCustomer(
            @PathVariable("customerId") Integer customerId,
            @RequestBody CustomerUpdateRequest updateRequest
    ) {
        customerService.updateCustomer(customerId, updateRequest);
    }
}