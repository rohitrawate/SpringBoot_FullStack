package com.rohit.configuration;

import org.springframework.boot.jackson.autoconfigure.JsonMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import tools.jackson.databind.ser.std.SimpleBeanPropertyFilter;
import tools.jackson.databind.ser.std.SimpleFilterProvider;

@Configuration
public class JacksonConfig2 {
    
    @Bean
    public JsonMapperBuilderCustomizer filterCustomizer() {
    	MappingJackson2HttpMessageConverter   jsonConverter = 
    			new MappingJackson2HttpMessageConverter();
    	
        return builder -> {
            SimpleFilterProvider filterProvider = new SimpleFilterProvider()
                .setFailOnUnknownId(false)
                .setDefaultFilter(SimpleBeanPropertyFilter.serializeAllExcept());  // Default: show all
                
            builder.filterProvider(filterProvider);
        };
    }
    
   
}
