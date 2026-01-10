//package com.rohit.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import tools.jackson.databind.ObjectMapper;
//import tools.jackson.databind.ObjectWriter;
//import tools.jackson.databind.ser.std.SimpleBeanPropertyFilter;
//import tools.jackson.databind.ser.std.SimpleFilterProvider;
//
//@Configuration
//public class JacksonConfig {
//	
//	@Bean
//	public ObjectMapper objectMapper() {
//		   ObjectMapper mapper = new ObjectMapper();
//		
//		SimpleFilterProvider filterProvider = new SimpleFilterProvider()
//					.setFailOnUnknownId(false)
// 				    .setDefaultFilter( SimpleBeanPropertyFilter.serializeAllExcept()); // Default show all
//		
//		ObjectWriter writer =  mapper.writer(filterProvider);
////		mapper.setFilterProvider(filterProvider);
//		
//		return mapper;
//	}
//
////	@Bean
////	public Jackson2ObjectMapperBuilderCustomizer customizer() {
////	    return builder -> 
////	    builder.filterProvider(new SimpleFilterProvider().setFailOnUnknownId(false)
////	        .setDefaultFilter(SimpleBeanPropertyFilter.serializeAllExcept()));
////	}
//
//}
