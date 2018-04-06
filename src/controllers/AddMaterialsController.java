package controllers;

import persist.DatabaseProvider;
import persist.FakeDatabase;
import persist.IDatabase;

import java.util.List;
import java.util.ArrayList;

public class AddMaterialsController {

	private IDatabase db = null;

	public AddMaterialsController() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new FakeDatabase());
		db = DatabaseProvider.getInstance();		
	}

	public boolean create(int modelId, List<List<String>> materials) {
		
		List<Integer> materialIds = new ArrayList<Integer> ();
		
		// insert the materials into DB
		for(List<String> material : materials) {
			if(material.get(0) != null) {
				materialIds.add(db.insertMaterialIntoMaterialTable(modelId, material.get(0), Integer.parseInt(material.get(1)), 
																material.get(2), material.get(3), material.get(4)));
			}
		}

		// check if the insertions succeeded
		if (!materialIds.contains(-1))
		{
			System.out.println("New material(s) (IDs: " +  materialIds.toString() + ") successfully added to Materials table.");
			
			return true;
		}
		else
		{
			List<Integer> failureIds = new ArrayList<> ();
			
			for(Integer id : materialIds) {
				if(id < 0) {
					failureIds.add(id);
				}
			}
			
			System.out.println("Failed to insert new material(s) (IDs: " + failureIds.toString() + ") into Materials table.");
			
			return false;
		}
	}
}
