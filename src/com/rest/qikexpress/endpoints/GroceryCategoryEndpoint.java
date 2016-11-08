package com.rest.qikexpress.endpoints;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.rest.qikexpress.objects.GroceryCategory;
import com.rest.qikexpress.sql.GroceryCategoryProject;

import java.util.ArrayList;

@Api(name = "grocerycategoryoperations", version = "v1")
public class GroceryCategoryEndpoint {

	public static ArrayList<GroceryCategory> groceryCategories = new ArrayList<GroceryCategory>();
	public static GroceryCategoryProject groceryCategoryProject;
	
	public GroceryCategoryEndpoint() {
		try {
			groceryCategoryProject = new GroceryCategoryProject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@ApiMethod(name="groceryCategories.all", path="groceryCategory/all")
	public ArrayList<GroceryCategory> listGroceries() throws Exception {
	    return groceryCategoryProject.getGroceryCategoriesAll();
	}

}
