package com.code.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class CustomerDataAccessService implements CustomerDao {

    private static List<Customer> customers;


    static {
        customers = new ArrayList<>();
        Customer alex = new Customer(1, "alex", "alex@email.com", 21);
        customers.add(alex);
        Customer james = new Customer(2, "james", "james@email.com", 30);
        customers.add(james);

    }


    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerId(Integer id) {

        return customers.stream().filter(c -> c.getId().equals(id)).
                findFirst();
    }
}
