package controllers;

import java.util.ArrayList;
import java.util.List;

import model.PhysicalModel;
import model.Profile;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;

public class ProfileOptionsController {

private IDatabase db = null;
	
	public ProfileOptionsController () {
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
				
		/*
		 * Uncomment below for Fake Database use
		 */
		//db = DatabaseProvider.getInstance();
	}
	
	public boolean changePassword(int profileId, String newPassword) {
		
		//return db.changePassword(profileId, newPassword);
		System.out.println("db.changePassword has not been implemented yet. Returning False");
		return false;
		
	}

	public boolean changeUsername(int profileId, String newUsername) {
		
		//return db.changeUsername(profileId, newUsername);
		System.out.println("db.changeUsername has not been implemented yet. Returning False");
		return false;
		
	}
	
	//any other methods
}