package com.capovskyAlexandr.zonkytest.customer.service;

import com.capovskyAlexandr.zonkytest.customer.entity.CustomerEntity;
import com.capovskyAlexandr.zonkytest.customer.exceptions.CustomerIsUnderAgeException;
import com.capovskyAlexandr.zonkytest.customer.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;

    CustomerService underTest;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        underTest=new CustomerService();

    }


    @Test
    void itShouldNotSaveCustomerAndThrowException() {
        //Given
        Integer givenCustomerID=1;
        Integer givenUnderAgeName=15;
        CustomerEntity givenCustomer= new CustomerEntity(givenCustomerID,"someName",givenUnderAgeName);
        //When

        //Then
        assertThrows(CustomerIsUnderAgeException.class,()->underTest.saveCustomer(givenCustomer));

    }
}