/**
 * 
 */
package com.karnee.global.cors.corsExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author karthik.sundarraj
 *
 */

@Configuration
@ComponentScan({ "com.karnee.global.cors" })
@PropertySource("classpath:application.properties")
public class CorsExampleCorsConfig implements WebMvcConfigurer {

	@Autowired
	private Environment environment;

	/*
	 * CORS constants currently all origins are accepted need to change while
	 * deploying in PROD environment
	 */
	public static final String ALLOWED_ORIGINS = "management.endpoints.app.cors.allowed-origins";
	public static final String MAX_AGE = "management.endpoints.app.cors.max-age";
	public static final String ALLOW_CREDENTIALS = "management.endpoints.app.cors.allowed-credentials";
	public static final String ALLOW_METHODS = "management.endpoints.app.cors.allowed-methods";
	public static final String COMMA_SEPERATOR = ",";

	
	
	/* (non-Javadoc)
	 * This method represents the Global configuration settings which is replaced by @CrossOrigins in the controllers and ReqeustMapping methods
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry)
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {

		String origins = environment.getProperty(this.ALLOWED_ORIGINS);
		String maxAge = environment.getProperty(this.MAX_AGE);
		String allowCreds = environment.getProperty(this.ALLOW_CREDENTIALS);
		String allowedMethods = environment.getProperty(this.ALLOW_METHODS);

		System.out.println("cors registry " + origins);
		registry.addMapping("/**").allowedOrigins(origins).allowedMethods(allowedMethods.split(this.COMMA_SEPERATOR))
				.allowCredentials(Boolean.valueOf(allowCreds)).maxAge(Long.valueOf(maxAge));
		System.out.println("CORS registry methods " + allowedMethods);
	}
}
