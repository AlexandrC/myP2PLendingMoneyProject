package com.capovskyAlexandr.zonkytest.customer.service;

import com.capovskyAlexandr.zonkytest.customer.entity.CustomerEntity;
import com.capovskyAlexandr.zonkytest.customer.exceptions.CustomerIsUnderAgeException;
import com.capovskyAlexandr.zonkytest.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    /***
     * Only save if the age is over 18 years old
     * @param customerEntity
     * @return
     */
    public CustomerEntity createCustomer(CustomerEntity customerEntity){

        if (customerEntity.getAge()<18){
            throw new CustomerIsUnderAgeException("Age of customer needs to be over 18 years old");
        }



        return customerRepository.save(customerEntity);

    }




}
