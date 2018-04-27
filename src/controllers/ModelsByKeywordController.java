package controllers;

//used Library Example as framework for this controller 

import java.util.ArrayList;
import java.util.List;

import model.PhysicalModel;

import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.FakeDatabase;
import persist.IDatabase;

public class ModelsByKeywordController {

	private IDatabase db = null;
	
	public ModelsByKeywordController () {
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
				
		/*
		 * Uncomment below for Fake Database use
		 */
		//db = DatabaseProvider.getInstance();	
	}	
	
public ArrayList<PhysicalModel> getModelByKeywords (String keyword){
		
	String [] split =keyword.split(" ");
	ArrayList <PhysicalModel> models = new ArrayList<PhysicalModel> ();
	
		for(int i=0; i<split.length; i++) {
			keyword = split[i];
			List <PhysicalModel> modelList = db.findModelsByKeyword(keyword);
	
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
		for(int i=0; i<models.size()-1; i++) {
			if(models.get(i).getId()==models.get(i+1).getId()) {
				models.remove(i);
			}
		}
		
		
		return models;
	}
	
	
}
