package com.capovskyAlexandr.zonkytest.customer.repository;

import com.capovskyAlexandr.zonkytest.customer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {

//    @Query("select c from CustomerEntity c where c.username Like %:userName%")
//    List<CustomerEntity> selectByUserName(@Param("userName")String userName);


}
