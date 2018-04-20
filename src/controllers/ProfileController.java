package controllers;

import java.util.ArrayList;
import java.util.List;

import model.PhysicalModel;
import model.Profile;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;

public class ProfileController {

private IDatabase db = null;
	
	public ProfileController () {
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
				
		/*
		 * Uncomment below for Fake Database use
		 */
		//db = DatabaseProvider.getInstance();
	}
	
	
	public List<PhysicalModel> getModels(int profileId) {
		
		List <PhysicalModel> models = db.findModelsByProfileId(profileId);
		
		return models;
	}
	
	public Profile getProfile(int profileId) {
		
		Profile profile = db.findProfileByProfileId(profileId);
		
		return profile;
	}
	
	public int getProfileIdByUsername(String username) {
		
		int id = db.findProfileIdByUsername(username);
		
		return id;
	}
}
