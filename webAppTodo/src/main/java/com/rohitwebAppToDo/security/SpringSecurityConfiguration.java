package com.rohitwebAppToDo.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.awt.Frame;
import java.util.function.Function;

import org.jspecify.annotations.Nullable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	// LDAP or Database
	// In Memory
	
	// InMemoryUserDetailsManager(UserDetails ..user)
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		UserDetails userDetails1 = createNewUser("in28min", "dummy");
//		UserDetails userDetails2 = createNewUser("rohit", "dummy123");
		
//		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
		return new InMemoryUserDetailsManager(userDetails1);
	}
	
	
	private UserDetails createNewUser(String username, String password) {
		
		Function< String, @Nullable String> passwordEncoder
					= input -> passwordEncoder().encode(input);
		
		UserDetails userDetails = User.builder()
				.passwordEncoder(passwordEncoder)
				.username(username)
				.password(password)
				.roles("ADMIN", "USER")
				.build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())
//                .headers(headers -> headers.frameOptions(frame -> frame.disable()))
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/h2-console/**").permitAll()
//                        .anyRequest().authenticated()
//                );
			http.authorizeHttpRequests(
					   auth -> auth.anyRequest().authenticated());
			http.formLogin( withDefaults());
			
			http
	        .csrf(AbstractHttpConfigurer::disable)
	        .headers(headers -> headers.frameOptions(frame -> frame.disable()));
        return http.build();
    }
//	 -----=================== -----=================== -----===================
//	@Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/login", "/css/**", "/js/**").permitAll()
//                .anyRequest().authenticated()
//            )
//            .formLogin(form -> form
//                .loginPage("/login")
//                .defaultSuccessUrl("/", true) // 👈 control redirect
//                .permitAll()
//            )
//            .logout(logout -> logout
//                .logoutSuccessUrl("/login")
//            );
//
//        return http.build();
//    }
}
