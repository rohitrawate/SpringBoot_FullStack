package com.rohit.rest.webservices.restful_web_services_todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EntityScan(basePackages = { "helloworld", "todo", "basic",
        "com.rohit.rest.webservices.restful_web_services_todo.jwt" })
@ComponentScan(basePackages = { "helloworld", "todo", "basic",
        "com.rohit.rest.webservices.restful_web_services_todo.jwt" })
@SpringBootApplication
public class RestfulWebServicesTodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulWebServicesTodoApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("*")
                        .allowedOrigins("http://localhost:5173");

            }
        };

    }
}
