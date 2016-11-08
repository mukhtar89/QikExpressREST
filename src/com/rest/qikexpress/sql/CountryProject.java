package com.rest.qikexpress.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.rest.qikexpress.objects.Country;

public class CountryProject {

	private Database database;
	private Connection connection;

	public ArrayList<Country> getCountries() throws Exception {
		try {
			database = new Database();
			connection = database.getConnection();
			ArrayList<Country> countryData = new ArrayList<Country>();

			// String uname = request.getParameter("uname");
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM country");
			// ps.setString(1,uname);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Country countryObject = new Country(null);
				countryObject.setCountryName(rs.getString("country_name"));
				countryData.add(countryObject);
			}
			return countryData;
		} catch (Exception e) {
			throw e;
		}
	}

}
