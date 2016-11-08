package com.rest.qikexpress.endpoints;

import java.util.ArrayList;

import javax.inject.Named;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.response.NotFoundException;
import com.rest.qikexpress.objects.GroceryItem;
import com.rest.qikexpress.sql.GroceryItemProject;
	
@Api(name = "groceryitemsoperations", version = "v1")
public class GroceryItemEndpoint {

	public static ArrayList<GroceryItem> groceryItems = new ArrayList<GroceryItem>();
	public static GroceryItemProject groceryItemProject;
	
	public GroceryItemEndpoint() {
		try {
			groceryItemProject = new GroceryItemProject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@ApiMethod(name="groceryitems.select", path="groceryItems/select")
	public ArrayList<GroceryItem> getGroceryItem(@Named("placeid") String placeId) throws Exception {
		try {
			groceryItems.clear();
			groceryItems.addAll(groceryItemProject.getGroceryItemDetail(placeId));
			return groceryItems;
		} catch (IndexOutOfBoundsException e) {
			throw new NotFoundException("Record not found with an index: " + placeId);
		}
	}

	@ApiMethod(name="groceryitems.all", path="groceryItems/all")
	public ArrayList<GroceryItem> listGroceryItems() throws Exception {
	    return groceryItemProject.getGroceryItemsAll();
	}
	
	@ApiMethod(name="groceryitemcategories.all", path="groceryItemCategories/all")
	public ArrayList<String> listGroceryItemCategories() throws Exception {
	    return groceryItemProject.getGroceryItemCategories();
	}

}
