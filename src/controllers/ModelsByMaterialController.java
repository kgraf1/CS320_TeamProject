package controllers;

//used library example as framework for controller

import java.util.ArrayList;
import java.util.List;

import model.PhysicalModel;

import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.FakeDatabase;
import persist.IDatabase;


public class ModelsByMaterialController {

	private IDatabase db = null;
	
	public ModelsByMaterialController () {
		// creating DB instance here
		DatabaseProvider.setInstance(new FakeDatabase());
		db = DatabaseProvider.getInstance();		
	}
	
public ArrayList<PhysicalModel> getModelByMaterialName (String material){
		
		String [] split = material.split(" ");
		ArrayList <PhysicalModel> models = new ArrayList<PhysicalModel> ();
		
		for(int i=0; i<split.length; i++) {
			material=split[i];
			List <PhysicalModel> modelList = db.findModelsByMaterialName(material);
	
			if(modelList.isEmpty()) {
				models=null;
			}
			else {
				for(PhysicalModel model:modelList) {
					if(!models.contains(model)) {
					models.add(model);
					}
				}
			}
		}
		return models;
	}
	
}


