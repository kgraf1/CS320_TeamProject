package controllers;

//used Library Example as framework for this controller 

import java.util.ArrayList;
import java.util.List;

import model.PhysicalModel;

import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;


public class ModelsByProfileNameController {

	private IDatabase db = null;
	
	public ModelsByProfileNameController () {
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
	}
	
public ArrayList<PhysicalModel> getModelByProfileFirstOrLastName (String name){
		
		String [] split = name.split(" ");
		ArrayList <PhysicalModel> models = null;
		
		for(int i=0; i<split.length; i++) {
			name=split[i];
			List <PhysicalModel> modelList = db.findModelsByProfileFirstOrLastName(name);
	
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
