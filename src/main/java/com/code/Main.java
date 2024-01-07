package com.code;

import com.code.customer.CustomerController;
import com.code.customer.CustomerDao;
import com.code.customer.CustomerDataAccessService;
import com.code.customer.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class Main {



    public static void main(String[] args) {

/*
   never do this
    CustomerService customerService=
//                new CustomerService(new CustomerDataAccessService());
//        CustomerController customerController
//                = new CustomerController(customerService);
//
*/



        SpringApplication.run(Main.class,args);

    }





}