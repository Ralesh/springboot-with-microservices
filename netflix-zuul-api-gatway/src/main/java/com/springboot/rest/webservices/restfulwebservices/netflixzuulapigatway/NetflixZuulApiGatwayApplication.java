package com.springboot.rest.webservices.restfulwebservices.netflixzuulapigatway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

/*
 * API Gateway for authorization, authentication, fault tolerance etc...
 * Video 98 to 103
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class NetflixZuulApiGatwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatwayApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
}
