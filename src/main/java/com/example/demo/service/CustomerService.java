package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;

//metodos que se pueden implementar en la capa de servicio
public interface CustomerService {
    List<Customer> findAllCustomers();
}
