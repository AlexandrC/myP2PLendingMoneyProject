package com.capovskyAlexandr.zonkytest.customer.repository;

import com.capovskyAlexandr.zonkytest.entity.CustomerEntity;
import com.capovskyAlexandr.zonkytest.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository underTest;
    CustomerEntity expectedCustomer;

    @BeforeEach
    void setUp() {
        Integer id = 1;
        expectedCustomer = new CustomerEntity(id, "randomUserName", 18);

    }

    @Test
    void itShouldsaveCustomer() {
        //Given

        //When
        underTest.save(expectedCustomer);

        //Then
        Optional<CustomerEntity> actualCustomer = underTest.findById(expectedCustomer.getId());

        assertTrue(new ReflectionEquals(expectedCustomer).matches(actualCustomer.get()));

    }

    @Test
    void itShouldFindCustomerEntityByUserName() {
        //Given

        //When
        underTest.save(expectedCustomer);
        //Then
        Optional<CustomerEntity> actualCustomer = underTest.findByUserName(expectedCustomer.getUserName());
        assertNotNull(actualCustomer);

    }

    @Test
    void itShouldFindTheCustomerByCertainAge() {
        //Given
        Integer id2 = 2;
        String userName2="randomUserName2";
        Integer age2=21;
        CustomerEntity expectedCustomer2 = new CustomerEntity(id2, userName2, age2);
        List<CustomerEntity> expectedListOfCustomer=new ArrayList<>();
        expectedListOfCustomer.add(expectedCustomer);
        expectedListOfCustomer.add(expectedCustomer2);

        //When
        underTest.save(expectedCustomer);
        underTest.save(expectedCustomer2);
        //Then
        List<CustomerEntity> actualCustomer=underTest.findCustomerEntitiesByAgeIsGreaterThanEqual(expectedCustomer.getAge());
        assertAll("properties of List",
                ()-> assertEquals(expectedCustomer.getAge(),actualCustomer.get(0).getAge()),
                ()->assertEquals(expectedCustomer.getUserName(),actualCustomer.get(0).getUserName()),
                ()-> assertEquals(expectedCustomer2.getAge(),actualCustomer.get(1).getAge()),
                ()->assertEquals(expectedCustomer2.getUserName(),actualCustomer.get(1).getUserName())
                );

    }
}