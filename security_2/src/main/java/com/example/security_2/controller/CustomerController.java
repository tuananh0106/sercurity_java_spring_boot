package com.example.security_2.controller;

import com.example.security_2.model.entity.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    final private List<Customer> customers = List.of(
            Customer.builder().id("1").name("Customer 1").email("c1@gmail.com").build(),
            Customer.builder().id("2").name("Customer 2").email("c2@gmail.com").build()
    );

//    @GetMapping("/hello")
//    public ResponseEntity<String> hello() {
//        return ResponseEntity.ok("hello is exception");
//    }

    @GetMapping("/customer/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Customer> getCustomerDetail(@PathVariable("id") String id) {
        List<Customer> customers = this.customers.stream().filter(customer -> customer.getId().equals(id)).toList();
        return ResponseEntity.ok(customers.get(0));
    }

    @GetMapping("/customer/all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Customer>> getCustomerList() {
        return ResponseEntity.ok(customers);
    }
}
