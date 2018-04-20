package controllers;

import java.util.ArrayList;
import java.util.List;

import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.FakeDatabase;
import persist.IDatabase;

public class AddApplicationController {

	private IDatabase db = null;

	public AddApplicationController() {
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
				
		/*
		 * Uncomment below for Fake Database use
		 */
		//db = DatabaseProvider.getInstance();	
	}

	public boolean create(int modelId, String beforeClass, String beforeImage, String duringClass, String duringImage) {
		System.out.println("Create from AddApplicationController is being called");
		int id = -1;
		//System.out.println("beforeClass is: "+beforeClass+" beforeImage is: "+beforeImage+
		//		" duringClass is: "+duringClass+" duringImage is: "+duringImage);
		if(beforeClass.equals("") && beforeImage.equals("") && duringClass.equals("") && duringImage.equals("")) {
			System.out.println("Failed to insert new application (ID: " + id + ") into Application table. All feilds are empty");
			return false;
		}
		else {
			System.out.println("At least one attribute is not empty, adding to the database");
		}
		// insert the application into DB
		id = db.insertApplicationIntoApplicationTable(modelId, beforeClass, beforeImage, duringClass, duringImage);
		
		// check if the insertion succeeded
		if (id != -1)
		{
			System.out.println("New application (ID: " +  id + ") successfully added to Application table.");
			
			return true;
		}
		else
		{			
			System.out.println("Failed to insert new application (ID: " + id + ") into Application table: id = -1");
			
			return false;
		}
	}
}
