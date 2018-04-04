package controller;

import java.util.ArrayList;
import java.util.List;

import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;

public class AddApplicationController {

	private IDatabase db = null;

	public AddApplicationController() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
	}

	public boolean create(int modelId, String beforeClass, String beforeImage, String duringClass, String duringImage) {
		
		int id = -1;
		
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
			System.out.println("Failed to insert new application (ID: " + id + ") into Application table.");
			
			return false;
		}
	}
}
