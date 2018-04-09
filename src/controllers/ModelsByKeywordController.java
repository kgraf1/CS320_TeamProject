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
		DatabaseProvider.setInstance(new FakeDatabase());
		db = DatabaseProvider.getInstance();		
	}	
	
public ArrayList<PhysicalModel> getModelByKeywords (String keywords){
		
		String [] split = keywords.split(" ");
		ArrayList <PhysicalModel> models = new ArrayList<PhysicalModel>();
		
		for(int i=0; i<split.length; i++) {
			String keyword=split[i];
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
		return models;
	}
	
}
