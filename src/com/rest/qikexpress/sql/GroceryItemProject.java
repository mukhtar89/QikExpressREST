package com.rest.qikexpress.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.rest.qikexpress.objects.GroceryItem;

public class GroceryItemProject {

	private Database database;
	private Connection connection;

	public GroceryItemProject() throws Exception {
		database = new Database();
		connection = database.getConnection();
	}

	private ArrayList<GroceryItem> getGroceryItems(PreparedStatement statement) throws Exception {
		ArrayList<GroceryItem> groceryItemData = new ArrayList<GroceryItem>();
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			GroceryItem groceryItemObject = new GroceryItem();
			if (rs.getMetaData().getColumnCount() > 7) {
				groceryItemObject.setGroceryId(rs.getString("grocery_id"));
				groceryItemObject.setGroceryItemPriceValue(rs.getFloat("grocery_item_price_value"));
			}
			groceryItemObject.setGroceryItemId(rs.getInt("grocery_item_id"));
			groceryItemObject.setGroceryItemName(rs.getString("grocery_item_name"));
			groceryItemObject.setGroceryItemImage(rs.getString("grocery_item_image"));
			groceryItemObject.setCatLev1(rs.getString("lev1"));
			groceryItemObject.setCatLev2(rs.getString("lev2"));
			groceryItemObject.setCatLev3(rs.getString("lev3"));
			groceryItemObject.setCatLev4(rs.getString("lev4"));
			groceryItemData.add(groceryItemObject);
		}
		return groceryItemData;
	}
	
	public ArrayList<String> getGroceryItemCategories() throws Exception {
		PreparedStatement statement = connection.prepareStatement("select distinct(grocery_category_name) from grocery_category where grocery_category_parent is null;");
		ArrayList<String> groceryItemCatgories = new ArrayList<String>();
		ResultSet rs = statement.executeQuery();
		while (rs.next()) 
			groceryItemCatgories.add(rs.getString("grocery_category_name"));
		return groceryItemCatgories;
	}
	
	public ArrayList<GroceryItem> getGroceryItemDetail(String placeId) throws Exception {
		PreparedStatement ps = connection.prepareStatement("select * from grocery_excl_items_price where grocery_id like '" + placeId + "' order by lev1");
		return getGroceryItems(ps);
	}

	public ArrayList<GroceryItem> getGroceryItemsAll() throws Exception  {
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM grocery_item_category_tree_compiled");
		return getGroceryItems(ps);
	}
}
