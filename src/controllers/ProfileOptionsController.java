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
	
	public boolean changePassword(String username, String newPassword) {
		
		int profileId = db.findProfileIdByUsername(username);
		
		int result = db.changePassword(profileId, newPassword);	
		
		if(result == 0) {
			System.out.println("After query, new password is: " + db.findProfileByProfileId(profileId).getPassword());
			return true;
		}
		else {
			return false;
		}
	}

	public boolean changeUsername(String username, String newUsername) {
		
		int profileId = db.findProfileIdByUsername(username);
		
		int result = db.changeUsername(profileId, newUsername);	
		
		if(result == 0) {
			return true;
		}
		else {
			return false;
		}
	}
}