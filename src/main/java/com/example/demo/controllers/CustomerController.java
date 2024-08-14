package com.example.demo.controllers;

import com.example.demo.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    //lista para los datos
    private final List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1, "Pablo", "Uchuari", "1234", "asdf1@gmail.com"),
            new Customer(2, "Gustavo", "Uchuari", "1234", "asdf2@gmail.com"),
            new Customer(3, "Clarks", "Uchuari", "1234", "asdf3@gmail.com"),
            new Customer(4, "kats", "Moay", "1234", "asdf4@gmail.com")
    ));

    //metodo como endpoint
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        //Codigo de respuesta 200 -
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable int id) {
        //for each
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                //Codigo de respuesta 200 -
                return ResponseEntity.ok(customer);
            }
        }
        //Codigo de respuesta 404 - usuario no encontrado
        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body("Customer not found, please check the id: " + id);
    }

    @PostMapping
    public ResponseEntity<?> postCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId()).toUri();
        //Codigo de respuesta 201 - muestra la URI con la que se puede consumir el recurso y el objeto creado
        return ResponseEntity.created(location).body(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putCustomer(@PathVariable int id, @RequestBody Customer customer) {
        for (Customer custom : customers) {
            if (custom.getId() == id) {
                custom.setName(customer.getName());
                custom.setUsername(customer.getUsername());
                custom.setPassword(customer.getPassword());
                custom.setEmail(customer.getEmail());
                //Codigo de respuesta 204 - exitoso, pero no muestra ningun mensaje
                return ResponseEntity.noContent().build();
            }
        }
        //Codigo de respuesta 404 - usuario no encontrado
        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body("Customer not found, please check the id: " + id);
        /*
        Codigo de respuesta 404 - sin mensaje
        return  ResponseEntity.notFound().build();
        */
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchCustomer(@PathVariable int id, @RequestBody Customer customer) {
        for (Customer custom : customers) {
            if (custom.getId() == id) {
                if (customer.getName() != null) {
                    custom.setName(customer.getName());
                }
                if (customer.getUsername() != null) {
                    custom.setUsername(customer.getUsername());
                }
                if (customer.getPassword() != null) {
                    custom.setPassword(customer.getPassword());
                }
                if (customer.getEmail() != null) {
                    custom.setEmail(customer.getEmail());
                }
                //Codigo de respuesta 200 - permite mostrar el mensaje
                return ResponseEntity.ok("Customer modified successful: " + id);
            }
        }
        //Codigo de respuesta 404 - usuario no encontrado
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Customer not found, please check the id: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
        //verifica que exita el elemento antes de eliminarlo
        Optional<Customer> cust = customers.stream().filter(customer -> customer.getId() == id).findFirst();
        //si no existe
        if (cust.isEmpty()) {
            //Codigo de respuesta 404 - usuario no encontrado
            return ResponseEntity.notFound().build();
        }
        //si existe sale
        customers.removeIf(customer -> customer.getId() == id);
        //codigo de respuesto 204 - respuesta exitosa sin contenido ni mensaje
        return ResponseEntity.noContent().build();
    }
}
