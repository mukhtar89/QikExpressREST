package com.rest.qikexpress.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rest.qikexpress.objects.Grocery;

public class GroceryProject {

	private Database database;
	private Connection connection;

	public GroceryProject() throws Exception {
		database = new Database();
		connection = database.getConnection();
	}

	private ArrayList<Grocery> getGroceries(PreparedStatement statement) throws Exception {
		ArrayList<Grocery> groceryData = new ArrayList<Grocery>();
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			Grocery groceryObject = new Grocery();
			groceryObject.setPlaceId(rs.getString("grocery_id"));
			groceryObject.setBrandId(rs.getInt("grocery_brand_id"));
			groceryObject.setProfileImage(rs.getString("grocery_brand_profile_image"));
			groceryObject.setPhotoReference(rs.getString("grocery_photo_reference"));
			groceryObject.setPhotoWidth(rs.getInt("grocery_photo_width"));
			groceryData.add(groceryObject);
		}
		return groceryData;
	}
	
	public Grocery getGroceryDetail(String placeId) throws Exception {
		PreparedStatement ps = connection.prepareStatement("select * from grocery_brand_compiled where grocery_id like '" + placeId + "'");
		return getGroceries(ps).get(0);
	}

	public ArrayList<Grocery> getGroceriesAll() throws Exception  {
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM grocery");
		return getGroceries(ps);
	}
}
