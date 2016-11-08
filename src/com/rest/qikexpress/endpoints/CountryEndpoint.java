package com.rest.qikexpress.endpoints;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.response.NotFoundException;
import com.rest.qikexpress.objects.Country;
import com.rest.qikexpress.sql.CountryProject;

import java.util.ArrayList;

import javax.inject.Named;

@Api(name = "countryoperations", version = "v1")
public class CountryEndpoint {

	public static ArrayList<Country> countries = new ArrayList<Country>();
	
	public CountryEndpoint() {
		try {
			/*groceries.add(new Country("India"));
			groceries.add(new Country("Saudi Arabia"));*/
			countries = new CountryProject().getCountries();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@ApiMethod(name="groceries.first", path="country/first")
	public Country getCountry(@Named("id") Integer id) throws NotFoundException {
		try {
			return countries.get(id);
		} catch (IndexOutOfBoundsException e) {
			throw new NotFoundException("Greeting not found with an index: " + id);
		}
	}

	@ApiMethod(name="groceries.all", path="country/all")
	public ArrayList<Country> listCountries() {
	    return countries;
	  }

}
