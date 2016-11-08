package com.rest.qikexpress.endpoints;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.response.NotFoundException;
import com.rest.qikexpress.objects.Grocery;
import com.rest.qikexpress.sql.GroceryProject;

import java.util.ArrayList;

import javax.inject.Named;

@Api(name = "groceryoperations", version = "v1")
public class GroceryEndpoint {

	public static ArrayList<Grocery> groceries = new ArrayList<Grocery>();
	public static GroceryProject groceryProject;
	
	public GroceryEndpoint() {
		try {
			groceryProject = new GroceryProject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@ApiMethod(name="groceries.select", path="grocery/select")
	public ArrayList<Grocery> getGrocery(@Named("placeid") String placeId) throws Exception {
		try {
			groceries.clear();
			groceries.add(groceryProject.getGroceryDetail(placeId));
			return groceries;
		} catch (IndexOutOfBoundsException e) {
			throw new NotFoundException("Record not found with an index: " + placeId);
		}
	}

	@ApiMethod(name="groceries.all", path="grocery/all")
	public ArrayList<Grocery> listGroceries() throws Exception {
	    return groceryProject.getGroceriesAll();
	}

}
