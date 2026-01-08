package com.rohit.rest.webservices.versioning;

public class PersonV1 {

	private String name;
	
	public PersonV1(String name) {
		super();
		this.name = name;
	}

	public String getName() {    // IMP Get is required to print output in API
		return name;
	}

//	public void setName(String name) {
//		this.name = name;
//	}

	@Override
	public String toString() {
		return "PersonV1 [name="+ name + "]" ;
	}
}
