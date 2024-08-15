package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;

//metodos que se pueden implementar en la capa de servicio
public interface CustomerService {
    //metodo para listar todos los customers
    List<Customer> findAllCustomers();

    //metodo para encontrar un customer por su id
    Customer findCustomerById(long id);

    //metodo para crear un customer
    Customer saveCustomer(Customer customer);

    //metodo para actualizar un customer
    Customer updateCustomer(long id, Customer customer);

    //metodo para eliminar un customer
    void deleteCustomer(long id);
}
