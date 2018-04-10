package controllers;

//used Library example as framework for controller

import java.util.ArrayList;
import java.util.List;

import model.PhysicalModel;

import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.FakeDatabase;
import persist.IDatabase;

public class ModelsByCategoryController {
	
	private IDatabase db = null;
	
	public ModelsByCategoryController (){
		// retrieving DB instance here
		db = DatabaseProvider.getInstance();	
	}
	
	
	public ArrayList<PhysicalModel> getModelByCategory (String category){
		String [] split = category.split(" ");
		ArrayList <PhysicalModel> models = null;
		
		for(int i=0; i<split.length; i++) {
			category=split[i];
			List <PhysicalModel> modelList = db.findModelsByCategory(category);
	
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
