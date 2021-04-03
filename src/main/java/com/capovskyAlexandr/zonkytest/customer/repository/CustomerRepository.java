package com.capovskyAlexandr.zonkytest.customer.repository;

import com.capovskyAlexandr.zonkytest.customer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {


    Optional<CustomerEntity> findByUserName(@Param("userName")String userName);



    List<CustomerEntity> findCustomerEntitiesByAgeIsGreaterThanEqual(Integer age);




}
