package com.capovskyAlexandr.zonkytest;

import com.capovskyAlexandr.zonkytest.entity.CustomerEntity;
import com.capovskyAlexandr.zonkytest.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ZonkytestApplicationTests {

	@Autowired
	CustomerRepository underTest;

	@Test
	void itShouldsaveCustomer() {
		//Given
		Integer id=1;
		CustomerEntity expectedCustomer= new CustomerEntity(id,"randomUserName",15);
		//When
		underTest.save(expectedCustomer);

		//Then
		Optional<CustomerEntity> actualCustomer=underTest.findById(id);

		assertTrue(new ReflectionEquals(expectedCustomer).matches(actualCustomer.get()));


	}
}
