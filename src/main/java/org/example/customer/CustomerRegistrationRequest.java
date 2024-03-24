package org.example.customer;

public record CustomerRegistrationRequest (
        String name,
        String email,
        Integer age
) {

}