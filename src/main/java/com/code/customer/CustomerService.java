package com.code.customer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {



    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomer(){

    return customerDao.selectAllCustomers();
    }

    public Customer getCustomer(Integer id){
        return customerDao.selectCustomerId(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer with id [%s] not found".formatted(id)));
    }


}
