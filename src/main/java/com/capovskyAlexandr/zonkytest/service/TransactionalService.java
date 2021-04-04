package com.capovskyAlexandr.zonkytest.service;

import com.capovskyAlexandr.zonkytest.entity.CustomerEntity;
import com.capovskyAlexandr.zonkytest.entity.MoneyTransfer;
import com.capovskyAlexandr.zonkytest.repository.CustomerRepository;
import com.capovskyAlexandr.zonkytest.repository.TransactionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Optional;

@Service
public class TransactionalService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TransactionalRepository transactionalRepository;

    public BigDecimal lendMoney(Integer custumerId, MoneyTransfer moneyTransfer){
        Optional<CustomerEntity> customer=customerRepository.findById(custumerId);
        if (customer.isPresent()){


            customer.get().setCurrentMoneyBalance(moneyTransfer.getMoneyValue().negate());
            saveMoneyTransferToDb(moneyTransfer);
            customerRepository.save(customer.get());

        }
        else {
            throw new RuntimeException("Customer Id was not found");
        }

        return customer.get().getCurrentMoneyBalance();

    }

    private MoneyTransfer saveMoneyTransferToDb(MoneyTransfer moneyTransfer){

        moneyTransfer.setMoneyCurrency(Currency.getInstance("USN"));
        transactionalRepository.save(moneyTransfer);

        return moneyTransfer;

    }

}
