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
		// retrieving DB instance here
		db = DatabaseProvider.getInstance();		
	}
	
public ArrayList<PhysicalModel> getModelByMaterialName (String material){
		
		String [] split = material.split(" ");
		ArrayList <PhysicalModel> models = new ArrayList<PhysicalModel> ();
		
		for(int i=0; i<split.length; i++) {
			material=split[i];
			List <PhysicalModel> modelList = db.findModelsByMaterialName(material);
			System.out.println("ModelsByMaterial is looking for: "+material); 
			if(modelList.isEmpty()) {
				models=null;
			}
			else {
				for(PhysicalModel model:modelList) {
					if(!models.contains(model)) {
					models.add(model);
					System.out.println("Adding "+model.getTitle()+" to models to return");
					}
					else {
						System.out.println(model.getTitle()+" is already in the array");
					}
				}
			}
		}
		return models;
	}
	
}


