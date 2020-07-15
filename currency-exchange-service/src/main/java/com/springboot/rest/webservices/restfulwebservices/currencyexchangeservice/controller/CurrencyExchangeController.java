package com.springboot.rest.webservices.restfulwebservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.webservices.restfulwebservices.currencyexchangeservice.Entity.ExchangeValue;
import com.springboot.rest.webservices.restfulwebservices.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment env;
	@Autowired
	private ExchangeValueRepository exValRepository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		//ExchangeValue exchangeValue = new ExchangeValue(1000L, "USD", "INR", BigDecimal.valueOf(65));
		ExchangeValue exchangeValue = exValRepository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		
		logger.info("{}", exchangeValue);
		return exchangeValue;
	}
	
	@GetMapping("/currency-exchange/update-status/{status}/from/{from}/to/{to}")
	public ExchangeValue updateExchangeValue(@PathVariable String status, @PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = exValRepository.findByFromAndTo(from, to);
		exchangeValue.setStatus(status);
		exValRepository.save(exchangeValue);
		exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		logger.info("{}", exchangeValue);
		return exchangeValue;
	}
}
