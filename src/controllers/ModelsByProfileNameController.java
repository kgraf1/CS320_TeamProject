package controllers;

//used Library Example as framework for this controller 

import java.util.ArrayList;
import java.util.List;

import model.PhysicalModel;

import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.FakeDatabase;
import persist.IDatabase;


public class ModelsByProfileNameController {

	private IDatabase db = null;
	
	public ModelsByProfileNameController () {
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
				
		/*
		 * Uncomment below for Fake Database use
		 */
		//db = DatabaseProvider.getInstance();		
	}
	
	public ArrayList<PhysicalModel> getModelByProfileFirstOrLastName (String name){
		
		String [] split = name.split(" ");
		ArrayList <PhysicalModel> models = new ArrayList<PhysicalModel>();
		
		System.out.println("***************** In Controller ***********");
		for(int i=0; i<split.length; i++) {
			name=split[i];
			List <PhysicalModel> modelList = db.findModelsByProfileFirstOrLastName(name);
	
			if(modelList.isEmpty()) {
				return null;
			}
			else {
				for(PhysicalModel model:modelList) {
					if(!models.contains(model)) {
					models.add(model);
					}
				}
			}
		}
	
	//**DO NOT REMOVE, THIS IS WHAT GETS RID OF DUPLICATE RESULTS//
		for (int i = 0; i < models.size(); i++) {
		     for (int j = i + 1 ; j < models.size(); j++) {
		          if (models.get(i).getId() == models.get(j).getId()) {
		                   models.remove(j);
		          }
		     }
		 }
	
	
		
		return models;
	}
	
}
