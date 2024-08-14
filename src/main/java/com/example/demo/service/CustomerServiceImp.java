package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    CustomerReposotory customerRepo;

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepo.findAll();
    }
}
