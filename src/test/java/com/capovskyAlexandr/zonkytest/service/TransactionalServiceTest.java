package com.capovskyAlexandr.zonkytest.service;

import com.capovskyAlexandr.zonkytest.entity.CustomerEntity;
import com.capovskyAlexandr.zonkytest.entity.MoneyTransfer;
import com.capovskyAlexandr.zonkytest.repository.CustomerRepository;
import com.capovskyAlexandr.zonkytest.repository.TransactionalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TransactionalServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @Mock
    TransactionalRepository transactionalRepository;

    @InjectMocks
    TransactionalService underTest;

    @BeforeEach
    void setUp(){

        MockitoAnnotations.openMocks(this);


    }



    @Test
    void itShouldLendMoney() {
        //Given
        Optional<CustomerEntity> expectedCustomer= Optional.of(new CustomerEntity(1, "RandomName", 20));
        BigDecimal expectedReturnValue= BigDecimal.valueOf(150.0);
        expectedCustomer.get().setCurrentMoneyBalance(expectedReturnValue);
        MoneyTransfer moneyTransfer = new MoneyTransfer();
        moneyTransfer.setMoneyValue(expectedReturnValue);
        //When
        when(customerRepository.findById(expectedCustomer.get().getId())).thenReturn(expectedCustomer);


        BigDecimal actualValue=underTest.lendMoney(expectedCustomer.get().getId(),moneyTransfer);
        //Then

        assertEquals(expectedReturnValue,actualValue);
    }

    @Test
    void itShouldThrowCustomerNotFound() {
        //Given
        Optional<CustomerEntity> expectedCustomer= Optional.of(new CustomerEntity(1, "RandomName", 20));
        MoneyTransfer moneyTransfer =  new MoneyTransfer();
        //When
        when(customerRepository.findById(expectedCustomer.get().getId())).thenReturn(Optional.empty());
        //Then
        RuntimeException exception=assertThrows(RuntimeException.class,()-> underTest.lendMoney(1,moneyTransfer),"Expect that customer ID was not found");
        assertEquals("Customer Id was not found",exception.getMessage());
        assertEquals(RuntimeException.class,exception.getClass());
    }
}