package controllers;

//used Library Example as framework for this controller 

import java.util.ArrayList;
import java.util.List;

import model.PhysicalModel;

import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;


public class ModelsByTitleController {

	private IDatabase db = null;
	
	public ModelsByTitleController () {
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
	}
	
	
	public ArrayList<PhysicalModel> getModelByTitle (String title){
		String [] split = title.split(" ");
		ArrayList <PhysicalModel> models = null;
		
		for(int i=0; i<split.length; i++) {
			title=split[i];
			List <PhysicalModel> modelList = db.findModelsByTitle(title);
	
			if(modelList.isEmpty()) {
				models=null;
			}
			else {
				models=new ArrayList<PhysicalModel>();
				for(PhysicalModel model:modelList) {
					models.add(model);
				}
			}
		}
		return models;
	}	
}
