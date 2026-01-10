package com.rohit.rest.webservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonIgnoreProperties({"field1","filed2"})
//@JsonPropertyOrder({ "field3", "field2","field1" })
//@JsonFilter("SomeBeanFilter")  --> Gives 500 Error {Type definition error:}
public class Somebean {
	
	
	private String field1;
	@JsonIgnore
	private String field2;
	private String field3;
	
	public Somebean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getField1() {
		return field1;
	}

	public String getField2() {
		return field2;
	}

	public String getField3() {
		return field3;
	}

	@Override
	public String toString() {
		return "Somebean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}
	
	
	
	
	
	
}
