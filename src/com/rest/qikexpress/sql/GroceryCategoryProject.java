package com.rest.qikexpress.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.rest.qikexpress.objects.GroceryCategory;;

public class GroceryCategoryProject {

	private Database database;
	private Connection connection;

	public GroceryCategoryProject() throws Exception {
		database = new Database();
		connection = database.getConnection();
	}

	private ArrayList<GroceryCategory> getGroceryCategories(PreparedStatement statement) throws Exception {
		ArrayList<GroceryCategory> groceryCategoryData = new ArrayList<GroceryCategory>();
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			GroceryCategory groceryCategoryObject = new GroceryCategory();
			groceryCategoryObject.setCategoryName(rs.getString("grocery_category_name"));
			groceryCategoryObject.setCategoryImageURL(rs.getString("grocery_category_image"));
			groceryCategoryData.add(groceryCategoryObject);
		}
		return groceryCategoryData;
	}

	public ArrayList<GroceryCategory> getGroceryCategoriesAll() throws Exception  {
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM grocery_category");
		return getGroceryCategories(ps);
	}
}
