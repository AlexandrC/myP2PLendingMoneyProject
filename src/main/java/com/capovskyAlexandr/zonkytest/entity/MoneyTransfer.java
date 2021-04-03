package com.capovskyAlexandr.zonkytest.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Currency;

@Entity
@Getter
@Setter
public class MoneyTransfer {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    BigDecimal moneyValue;
    Currency currency;


}
