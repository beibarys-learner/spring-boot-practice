package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController

public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public GreetResponse greet(@RequestParam(value = "name", required = false) String name){
        String greetMessage = name.isBlank() ? "Salem " : "Salem " + name;
        // introduced new local variable
        GreetResponse response = new GreetResponse(
//                "Salem",
                greetMessage,
                List.of("Java", "Python", "Javascript"),
                new Person("James Gosling ", 68, 50_000_000.0)
        );
        return response;
    }

    // add a record
    record Person(String name, int age, double savings){
    }
    record GreetResponse(String greet, List<String> freqProgLang, Person person){}
}
