package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Customer;
//permite extender metodos de la interface jpaRepository-spring data
//recibe como parametros la entidad y la el tipo de dato de la PK
public interface CustomerReposotory extends JpaRepository<Customer, Long> {

}
