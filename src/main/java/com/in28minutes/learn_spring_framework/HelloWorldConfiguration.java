package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Address(String firstLine, String city) { }
record Person(String name, int age, Address address) { }

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
        return new Person("Ravi", 22, new Address("31 Baker Street", "Nevada"));
    }

    // Utilize the existing Beans to create a new Bean - two ways
    // 1st way: Direct Method Call to the existing Beans
    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }

    // 2nd way: Parameter Injection (More preferable)
    @Bean
    public Person person3Parameters(String name, int age, Address address2) { // Here, we use the Bean name - address2
        return new Person(name, age, address2);
    }

    @Bean(name = "address2")
    public Address address() {
        return new Address("26A South-West Road", "Ohio");
    }
}
