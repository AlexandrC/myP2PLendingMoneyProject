package com.capovskyAlexandr.zonkytest.repository;

import com.capovskyAlexandr.zonkytest.entity.MoneyTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionalRepository extends JpaRepository<MoneyTransfer,Integer> {

}
