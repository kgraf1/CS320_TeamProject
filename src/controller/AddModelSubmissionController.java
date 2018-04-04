package controller;

import model.Category;
import persist.IDatabase;
import persist.DatabaseProvider;
import persist.DerbyDatabase;


public class AddModelSubmissionController {

	private IDatabase db = null;

	public AddModelSubmissionController() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
	}

	public int create(String title, String description, String thumbnail, String engPrinciple, String citation,
							Category category, String procedure) {
		
		// insert new model into DB
		Integer model_id = db.insertModelIntoPhysicalModelTable(title, description, thumbnail, engPrinciple, citation,
																category, procedure);

		// check if the insertion succeeded
		if (model_id > 0)
		{
			System.out.println("New model (ID: " + model_id + ") successfully added to PhysicalModel table: <" + title + ">");
			
			return model_id;
		}
		else
		{
			System.out.println("Failed to insert new model (ID: " + model_id + ") into PhysicalModel table: <" + title + ">");
			
			return -1;
		}
	}
}