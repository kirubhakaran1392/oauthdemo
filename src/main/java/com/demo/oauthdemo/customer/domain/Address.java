package com.demo.oauthdemo.customer.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue
	Long addressId;
	
	String addressType;
	String streetLine1;
	String streetLine2;
	String cityName;
	String stateCode;
	String postalCode;
	String postalCodePlus;
	String countryCode;
	
	@ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
	
	
	
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getStreetLine1() {
		return streetLine1;
	}
	public void setStreetLine1(String streetLine1) {
		this.streetLine1 = streetLine1;
	}
	public String getStreetLine2() {
		return streetLine2;
	}
	public void setStreetLine2(String streetLine2) {
		this.streetLine2 = streetLine2;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPostalCodePlus() {
		return postalCodePlus;
	}
	public void setPostalCodePlus(String postalCodePlus) {
		this.postalCodePlus = postalCodePlus;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	@Override
	public String toString() {
		return "Address [id=" + addressId + ", addressType=" + addressType + ", streetLine1=" + streetLine1 + ", streetLine2="
				+ streetLine2 + ", cityName=" + cityName + ", stateCode=" + stateCode + ", postalCode=" + postalCode
				+ ", postalCodePlus=" + postalCodePlus + ", countryCode=" + countryCode + ", customer=" + customer
				+ "]";
	}
	
	
}
