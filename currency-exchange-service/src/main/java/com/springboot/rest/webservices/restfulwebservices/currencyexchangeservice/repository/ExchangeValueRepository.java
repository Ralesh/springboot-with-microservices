package com.springboot.rest.webservices.restfulwebservices.currencyexchangeservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.webservices.restfulwebservices.currencyexchangeservice.Entity.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{
	
	/*
	 * Query which is getting fired during JPA invocation
	 * select exchangeva0_.id as id1_0_, exchangeva0_.conversion_multiple as conversi2_0_, exchangeva0_.conversion_from as conversi3_0_, exchangeva0_.port as port4_0_, exchangeva0_.conversion_to as conversi5_0_ from exchange_value exchangeva0_ where exchangeva0_.conversion_from=? and exchangeva0_.conversion_to=?
	 */
	ExchangeValue findByFromAndTo(String from, String to);
}
