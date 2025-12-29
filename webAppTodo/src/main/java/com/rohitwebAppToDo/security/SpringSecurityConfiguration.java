package com.rohitwebAppToDo.security;

import java.util.function.Function;

import org.jspecify.annotations.Nullable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	// LDAP or Database
	// In Memory
	
	// InMemoryUserDetailsManager(UserDetails ..user)
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		
		Function< String, @Nullable String> passwordEncoder
					= input -> passwordEncoder().encode(input);
		
		UserDetails userDetails = User.builder()
				.passwordEncoder(passwordEncoder)
				.username("in28min")
				.password("dummy")
				.roles("ADMIN", "USER")
				.build();
		
		return new InMemoryUserDetailsManager(userDetails);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
