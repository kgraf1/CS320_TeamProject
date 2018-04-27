package controllers;

import java.util.ArrayList;
import java.util.List;

import model.PhysicalModel;
import model.Rating;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.FakeDatabase;
import persist.IDatabase;

public class ModelsByProfileIdController {
	private IDatabase db = null;
	
	public ModelsByProfileIdController(){
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
				
		/*
		 * Uncomment below for Fake Database use
		 */
		//db = DatabaseProvider.getInstance();
	}
	public ArrayList<PhysicalModel> getModelsByProfileId (int profileId){
		ArrayList<PhysicalModel> models = null;
		List <PhysicalModel> modelList = db.findModelsByProfileId(profileId);
		
		if(modelList.isEmpty()) {
			models = null;
			System.out.println("Profile id# "+profileId+" does not have any models");
		}
		else {
			models = new ArrayList<PhysicalModel>();
			for( PhysicalModel model:modelList) {
				models.add(model);
			}
			System.out.println("Profile id# "+profileId+" has : "+modelList.size()+" models");
		}
		return models;
	}
}