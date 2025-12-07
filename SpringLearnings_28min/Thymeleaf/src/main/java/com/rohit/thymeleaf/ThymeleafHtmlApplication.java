package com.rohit.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ThymeleafHtmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafHtmlApplication.class, args);
		System.out.print("Thymeleaf-------");
	}

//	@GetMapping("/hello")
//	public String check() {
//		return "Hellooo";
//	}

}
