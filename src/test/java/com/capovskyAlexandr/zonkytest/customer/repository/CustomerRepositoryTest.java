package com.capovskyAlexandr.zonkytest.customer.repository;

import com.capovskyAlexandr.zonkytest.customer.entity.CustomerEntity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository underTest;

    @Test
    void itShouldsaveCustomer() {
        //Given
        Integer id = 1;
        CustomerEntity expectedCustomer = new CustomerEntity(id, "randomUserName", 18);
        //When
        underTest.save(expectedCustomer);

        //Then
        Optional<CustomerEntity> actualCustomer = underTest.findById(id);

        assertTrue(new ReflectionEquals(expectedCustomer).matches(actualCustomer.get()));

    }

//    @Test
//    @Disabled
//    void itShouldFindCustomerEntityByUserName() {
//        //Given
//        Integer id = 1;
//        String userName="randomUserName";
//        CustomerEntity expectedCustomer = new CustomerEntity(id, userName, 18);
//        //When
//        underTest.save(expectedCustomer);
//        //Then
//        List<CustomerEntity> actualCustomer = underTest.selectByUserName(userName);
//        assertTrue(new ReflectionEquals(expectedCustomer).matches(actualCustomer));
//
//    }
}