package com.rohit.rest.webservices.filtering;

import java.util.Arrays;
import java.util.List;

import com.rohit.rest.webservices.exception.CustomizedResponseEntityExceptionHandler;

import tools.jackson.databind.ser.FilterProvider;
import tools.jackson.databind.ser.std.SimpleBeanPropertyFilter;
import tools.jackson.databind.ser.std.SimpleFilterProvider;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    private final CustomizedResponseEntityExceptionHandler customizedResponseEntityExceptionHandler;

    FilteringController(CustomizedResponseEntityExceptionHandler customizedResponseEntityExceptionHandler) {
        this.customizedResponseEntityExceptionHandler = customizedResponseEntityExceptionHandler;
    }
	
	@GetMapping("/filtering")
//	public MappingJacksonValue filtering() {
	public Somebean filtering() {
//		Somebean somebean = new Somebean("value1", "value2", "value3");
//		MappingJacksonValue mappingJ = new MappingJacksonValue(somebean);
//		
//		SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("field1", "filter3");
//		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
//		
//		mappingJ.setFilters(filters);
//		return mappingJ;
		return  new Somebean("value1", "value2", "value3");
	}
	/*
	  MappingJacksonValue wrapper = new MappingJacksonValue(object);
		wrapper.setFilters(filters);
		return wrapper;
	 */

	@GetMapping("/filtering-list")
	public List<Somebean> filteringList() {
		return Arrays.asList(new Somebean("value1", "value2", "value3"),
				           new Somebean("value4", "value5", "value6")	);
	}


}
