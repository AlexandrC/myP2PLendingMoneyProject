package com.capovskyAlexandr.zonkytest.controller.Transcation;

import com.capovskyAlexandr.zonkytest.entity.MoneyTransfer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

public interface Transaction {

    public ResponseEntity<BigDecimal>  lendMoney(Integer costumerId, MoneyTransfer moneyTransfer);

    public BigDecimal investMoney();


}
