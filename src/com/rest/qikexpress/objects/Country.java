package com.rest.qikexpress.objects;

public class Country {
	
	private String countryName;
	
	public Country(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the Country Name
	 */
	public String getCountryName() {
		return countryName;
	}
	/**
	 * @param title the title to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
