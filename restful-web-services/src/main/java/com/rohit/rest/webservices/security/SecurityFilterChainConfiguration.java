package com.rohit.rest.webservices.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springdoc.core.properties.SwaggerUiConfigProperties.Csrf;

import com.rohit.rest.webservices.exception.CustomizedResponseEntityExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityFilterChainConfiguration {

    private final CustomizedResponseEntityExceptionHandler customizedResponseEntityExceptionHandler;

    SecurityFilterChainConfiguration(CustomizedResponseEntityExceptionHandler customizedResponseEntityExceptionHandler) {
        this.customizedResponseEntityExceptionHandler = customizedResponseEntityExceptionHandler;
    }

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// All requests should be authenticated
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
		// If a requestis not authenticated, a webpage is shown
		http.httpBasic(withDefaults());
		// CSRF -> POST , PUT
		http.csrf(csrf -> csrf.disable());
		
		
    return http.build();
	}
}
