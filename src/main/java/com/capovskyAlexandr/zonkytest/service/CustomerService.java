package com.capovskyAlexandr.zonkytest.service;

import com.capovskyAlexandr.zonkytest.entity.CustomerEntity;
import com.capovskyAlexandr.zonkytest.exceptions.CustomerIsUnderAgeException;
import com.capovskyAlexandr.zonkytest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Currency;

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
        customerEntity.setMoneyInCurrency(Currency.getInstance("USN"));



        return customerRepository.save(customerEntity);

    }




}
