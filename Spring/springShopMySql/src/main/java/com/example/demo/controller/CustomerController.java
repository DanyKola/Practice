package com.example.demo.controller;

import com.example.demo.db.service.api.CustomerService;
import com.example.demo.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping
    public ResponseEntity add(@RequestBody Customer customer){
        Integer id = customerService.addCustomer(customer);
        if (id!=null){
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable int id){
        Customer customer = customerService.getCustomer(id);
        if (customer==null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity getAll(){
        List<Customer> customerList =customerService.getCustomers();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
}
