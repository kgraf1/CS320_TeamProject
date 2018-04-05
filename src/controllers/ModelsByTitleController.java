package controllers;

//used Library Example as framework for this controller 

import java.util.ArrayList;
import java.util.List;

import model.PhysicalModel;

import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.FakeDatabase;
import persist.IDatabase;


public class ModelsByTitleController {

	private IDatabase db = null;
	
	public ModelsByTitleController () {
		// creating DB instance here
		DatabaseProvider.setInstance(new FakeDatabase());
		db = DatabaseProvider.getInstance();		
	}
	
	
	public ArrayList<PhysicalModel> getModelByTitle (String title){
		//String [] split = title.split(" ");
		ArrayList <PhysicalModel> models = null;
		
		
			
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
		
		return models;
	}	
}
