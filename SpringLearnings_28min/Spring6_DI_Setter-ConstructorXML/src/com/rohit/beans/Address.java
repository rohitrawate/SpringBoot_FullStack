package com.rohit.beans;

public class Address {

	public Address() {
		System.out.println("Address obj created : Default Constructor");
	}

	public Address(int houseno, String city, int pincode) {
		System.out.println("Address obj created : Para Construction");
		this.houseno = houseno;
		this.city = city;
		this.pincode = pincode;
	}

	private int houseno;
	private String city;
	private int pincode;

	public int getHouseno() {
		return houseno;
	}

	public void setHouseno(int houseno) {
		System.out.println("setHouseno: " + houseno);
		this.houseno = houseno;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		System.out.println("setCity : " + city);
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		System.out.println("setPincode : " + pincode);
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [houseno=" + houseno + ", city=" + city + ", pincode=" + pincode + "]";
	}

}
