package org.example.customer;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.exception.DuplicateResourceException;
import org.example.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.zip.DataFormatException;

@Service
public class CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerService(@Qualifier("jpa") CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<Customer> getAllCustomers(){
        return customerDAO.selectAllCustomers();
    }

    public Customer getCustomer(Integer id){
        return customerDAO.selectAllCustomersById(id).
                orElseThrow(() -> new ResourceNotFound(
                                "customer with id [%s} not found".formatted(id)
                        ));
    }

    public void addCustomer(CustomerRegistrationRequest customerRegistrationRequest){
        // проверка почты
        String email = customerRegistrationRequest.email();
        if(customerDAO.existsPersonWithEmail(customerRegistrationRequest.email())){
            throw new DuplicateResourceException(
                    "email is already taken"
            );
        }

        // add
         Customer customer = new Customer(
                        customerRegistrationRequest.name(),
                        customerRegistrationRequest.email(),
                        customerRegistrationRequest.age()
                );
        customerDAO.insertCustomer(customer);
    }

    public void deleteCustomerByID(Integer customerId) {
        if(!customerDAO.existsPersonWithId(customerId)){
            throw new ResourceNotFound(
                    "customer with id [%s} not found".formatted(customerId)
            );
        }
    }

    public void updateCustomer(
            Integer customerId,
            CustomerUpdateRequest updateRequest
    ) {
        Customer customer = getCustomer(customerId);
        boolean changes = false;

        if(updateRequest.name() != null && !updateRequest.name().equals(customer.getName())){
            customer.setName(updateRequest.name());
            changes = true;
        }

        if(updateRequest.age() != null && !updateRequest.age().equals(customer.getAge())){
            customer.setAge(updateRequest.age());
            changes = true;
        }

        if(updateRequest.email() != null && !updateRequest.email().equals(customer.getEmail())){
            if(customerDAO.existsPersonWithEmail(updateRequest.email())){
                throw new DuplicateResourceException(
                        "email is already taken"
                );
            }
            customer.setEmail(updateRequest.email());
            changes = true;
        }
        if (!changes) {
            throw new RequestValidationException("no data changes found");
        }

        customerDAO.updateCustomer(customer);
    }


}
