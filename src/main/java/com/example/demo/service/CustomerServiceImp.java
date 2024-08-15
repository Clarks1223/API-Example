package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    CustomerReposotory customerRepo;

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Customer findCustomerById(long id) {
        if (Objects.isNull(id)) {
            return null;
        }
        if (!customerRepo.existsById(id)) {
            return null;
        }
        return customerRepo.findById(id).get();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer updateCustomer(long id, Customer customer) {
        Customer customerToUpdate = customerRepo.findById(id).get();
        if (customerToUpdate != null) {
            if (Objects.nonNull(customer.getName()) && !"".equalsIgnoreCase(customer.getName())) {
                customerToUpdate.setName(customer.getName());
            }
            if (Objects.nonNull(customer.getUsername()) && !"".equalsIgnoreCase(customer.getUsername())) {
                customerToUpdate.setUsername(customer.getUsername());
            }
        }
        return null;
    }

    @Override
    public void deleteCustomer(long id) {
        customerRepo.deleteById(id);
    }

}
