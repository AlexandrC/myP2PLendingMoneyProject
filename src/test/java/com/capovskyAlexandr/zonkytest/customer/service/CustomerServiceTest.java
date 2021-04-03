package com.capovskyAlexandr.zonkytest.customer.service;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import com.capovskyAlexandr.zonkytest.customer.entity.CustomerEntity;
import com.capovskyAlexandr.zonkytest.customer.exceptions.CustomerIsUnderAgeException;
import com.capovskyAlexandr.zonkytest.customer.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


class CustomerServiceTest {


    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService underTest;

    @BeforeEach
    void setUp(){

        MockitoAnnotations.openMocks(this);


    }


    @Test
    void itShouldNotSaveCustomerAndThrowException() {
        //Given
        Integer givenCustomerID=1;
        Integer givenUnderAgeName=15;
        CustomerEntity givenCustomer= new CustomerEntity(givenCustomerID,"someName",givenUnderAgeName);
        //When

        //Then
        assertThrows(CustomerIsUnderAgeException.class,()->underTest.createCustomer(givenCustomer));

    }

    @Test
    void itShouldSaveACustomer() {
        //Given
        Integer givenCustomerID=1;
        Integer givenUnderAgeName=19;
        CustomerEntity givenCustomer= new CustomerEntity(givenCustomerID,"someName",givenUnderAgeName);
        //When
        when(customerRepository.save(any(CustomerEntity.class))).thenReturn(givenCustomer);
        CustomerEntity actualCreatedCustomer=underTest.createCustomer(givenCustomer);
        //Then
            assertAll("return type of method save customer",
                ()->assertEquals(givenCustomer.getUserName(),actualCreatedCustomer.getUserName()),
                ()->assertEquals(givenCustomer.getAge(),actualCreatedCustomer.getAge()),
                ()->assertEquals(givenCustomer.getId(),actualCreatedCustomer.getId())
        );
    }
}