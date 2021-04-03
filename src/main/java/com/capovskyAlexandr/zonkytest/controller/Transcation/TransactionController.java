package com.capovskyAlexandr.zonkytest.controller.Transcation;

import com.capovskyAlexandr.zonkytest.entity.MoneyTransfer;
import com.capovskyAlexandr.zonkytest.service.TransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/transaction")
public class TransactionController implements Transaction {


    @Autowired
    TransactionalService transactionalService;


    @Override
    public BigDecimal investMoney() {
        return null;
    }

    @PostMapping(value = "/{customerId}/lendMoney")
    @Override
    public ResponseEntity<BigDecimal> lendMoney(@PathVariable Integer customerId, @RequestBody MoneyTransfer moneyTransfer) {
        return new ResponseEntity(transactionalService.lendMoney(customerId, moneyTransfer), HttpStatus.OK);
    }
}
