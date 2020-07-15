package com.springboot.rest.webservices.restfulwebservices.netflixzuulapigatway;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/*
	 * http://localhost:8000/currency-exchange/from/AUD/to/INR

http://localhost:8765/{application-name}/{uri}

http://localhost:8765/currency-exchange-service/currency-exchange/from/AUD/to/INR
http://localhost:8765/currency-conversion-service/currency-converter-feign/from/EUR/to/INR/quantity/10000
	
	/*
	 * Whether to filter the request or not
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}
	
	/*
	 * To be run with main business logic
	 * request -> org.springframework.cloud.netflix.zuul.filters.pre.Servlet30RequestWrapper@6454afda, 
	 * request uri -> /currency-exchange-service/currency-exchange/from/AUD/to/INR
	 */
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {}, request uri -> {}", request, request.getRequestURI());
		return null;
	}
	
	/*
	 * Filter type is pre/post/error
	 * it indicates when should be the filtering happen
	 * 1. Before the request is executed - "Pre"
	 * 2. After the request is executed - "Post"
	 * 3. Filter only for Error - "Error"
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
