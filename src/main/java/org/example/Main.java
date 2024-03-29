package org.example;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.example.customer.Customer;
import org.example.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;

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

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository){

//        customers.add(guido);

        return args -> {
            var faker = new Faker();
            Random random = new Random();

            Name name = faker.name();

            Customer customer = new Customer(
                    name.fullName(),
                    name.firstName().toLowerCase() + "." + name.lastName().toLowerCase() +"@proton.com",
                    random.nextInt(16, 99)
            );

            customerRepository.save(customer);

           /* Customer james = new Customer(
                    "James",
                    "java@gmail.com",
                    68
            );
//        customers.add(james);

            Customer guido = new Customer(
                    "Guido",
                    "python@gmail.com",
                    67
            );

            List<Customer> customers = List.of(james, guido);
            customerRepository.saveAll(customers);*/
        };
    }
}
