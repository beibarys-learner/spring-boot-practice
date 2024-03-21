package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController

public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public GreetResponse greet(){
        // introduced new local varuablle
        GreetResponse response = new GreetResponse(
                "Salem",
                List.of("Java", "Python", "Javascript"),
                new Person("James Gosling ")
        );
        return response;
    }

    // add a record
    record Person(String name){
    }
    record GreetResponse(String greet, List<String> freqProgLang, Person person){}
}
