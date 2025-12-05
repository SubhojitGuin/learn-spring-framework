package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age) { }
record Address(String firstLine, String city) { }

// Configure the things we want Spring to manage - @Configuration
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Ranga";
    }

    @Bean
    public int age() {
        return 21;
    }

    @Bean
    public Person person() {
        return new Person("Ravi", 22);
    }

    @Bean(name = "address2")
    public Address address() {
        return new Address("26A South-West Road", "Ohio");
    }
}
