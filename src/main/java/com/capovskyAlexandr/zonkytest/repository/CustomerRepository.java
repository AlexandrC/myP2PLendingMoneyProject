package com.capovskyAlexandr.zonkytest.repository;

import com.capovskyAlexandr.zonkytest.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {


}
