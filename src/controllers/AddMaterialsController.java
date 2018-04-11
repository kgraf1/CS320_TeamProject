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
		db = DatabaseProvider.getInstance();		
	}

	public boolean create(int modelId, List<List<String>> materials) {
		
		List<Integer> materialIds = new ArrayList<Integer> ();
		System.out.println("Adding New Materials");
		
		for(int i = 0; i < materials.size();i++) {
			if(materials.get(i).get(0)==null || materials.get(i).get(0).length() == 0) {
				materials.remove(i);
				i--;
			}
		}
		// insert the materials into DB
		for(List<String> material : materials) {
			if(material.get(0) != null) {
				materialIds.add(db.insertMaterialIntoMaterialTable(modelId, material.get(0), material.get(1), 
																material.get(2), material.get(3), material.get(4)));
				System.out.println("Material "+material.get(0)+" is not null, adding to fake database");
			}
			else{
				System.out.println("Material "+material.get(0)+" is null, will not be added to fake database");
			}
		}

		// check if the insertions succeeded
		if (!materialIds.contains(-1))
		{	
			if(materialIds.size()==0) {
				System.out.println("There are no new materials to add");
				return true;
			}
			else {
			System.out.println("New material(s) (IDs: " +  materialIds.toString() + ") successfully added to Materials table.");
			
			return true;
			}
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
