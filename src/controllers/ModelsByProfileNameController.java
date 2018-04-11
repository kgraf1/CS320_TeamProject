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
		// retrieving DB instance here
		db = DatabaseProvider.getInstance();		
	}
	
public ArrayList<PhysicalModel> getModelByProfileFirstOrLastName (String name){
		
		String [] split = name.split(" ");
		ArrayList <PhysicalModel> models = new ArrayList<PhysicalModel>();
		
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
		for(int i =0; i<models.size(); i++) {
			System.out.println(models.get(i));
		}
		return models;
	}
	
}
