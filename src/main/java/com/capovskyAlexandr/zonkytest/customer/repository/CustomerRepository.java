package com.capovskyAlexandr.zonkytest.customer.repository;

import com.capovskyAlexandr.zonkytest.customer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {


}
