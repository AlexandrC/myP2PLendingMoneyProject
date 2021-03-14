package com.capovskyAlexandr.zonkytest.service;

import com.capovskyAlexandr.zonkytest.entity.CustomerEntity;
import com.capovskyAlexandr.zonkytest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerEntity saveCustomer(CustomerEntity customerEntity){

        if (customerEntity.getAge()<18){
            

        }


        return customerRepository.save(customerEntity);

    }


}
