package com.capovskyAlexandr.zonkytest.controller;


import com.capovskyAlexandr.zonkytest.entity.CustomerEntity;
import com.capovskyAlexandr.zonkytest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(value = "/create")
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customer){




        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.ACCEPTED);



    }



}
