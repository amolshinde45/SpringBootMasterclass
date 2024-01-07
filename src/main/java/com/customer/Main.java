package com.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class Main {


    private static List<Customer> customers;

    static{
        customers= new ArrayList<>();
        Customer alex= new Customer(1,"alex","alex@email.com",21);
        customers.add(alex);
        Customer james= new Customer(2,"james","james@email.com",30);
        customers.add(james);

    }
    public static void main(String[] args) {

        SpringApplication.run(Main.class,args);

    }

//    @RequestMapping(
//            path = "api/v1/customer",
//            method = RequestMethod.GET
//
//    )

    @GetMapping("api/v1/customer")
    public static List<Customer> getCustomers() {
        return customers;
    }

    @GetMapping("api/v1/customer/{customerId}")
    public static Customer getCustomer(
            @PathVariable("customerId") Integer customerId) {

           Customer customer= customers.stream().filter(c -> c.id.equals(customerId)).
                    findFirst().orElseThrow(
                            () -> new IllegalArgumentException("Customer with id [%s] not found".formatted(customerId))
                    );
        return customer;
    }

    static class Customer{
        private Integer id;
        private String name;
        private String email;
        private Integer age;

        public Customer(){};
        public Customer(Integer id, String name, String email, Integer age) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.age = age;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Customer customer = (Customer) o;
            return id.equals(customer.id) && name.equals(customer.name) && email.equals(customer.email) && age.equals(customer.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, email, age);
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }
}