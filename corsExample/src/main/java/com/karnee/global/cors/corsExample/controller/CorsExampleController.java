/**
 * 
 */
package com.karnee.global.cors.corsExample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author karthik.sundarraj
 *
 */
@RestController
@RequestMapping("api")
public class CorsExampleController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.GET, value = "sayHelloFromCORS")
	public String sayHello() {
		logger.info("Welcome to CORS Method");
		return "Swagger Hello CORS Example";
	}
}
