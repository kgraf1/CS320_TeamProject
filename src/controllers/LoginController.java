package controllers;

import model.Profile;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import persist.DatabaseProvider;
import persist.FakeDatabase;
import persist.DerbyDatabase;
import persist.IDatabase;
import persist.InitialData;

public class LoginController {

	private IDatabase db = null;
	private List<Profile> profiles =null;
	
	public LoginController(Profile profile) {

		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
				
		/*
		 * Uncomment below for Fake Database use
		 */
		//db = DatabaseProvider.getInstance();
	}
	
	public boolean checkUserName(String username) {
		System.out.println("Checking username");
			profiles = db.getAllProfiles();
			for(int i=0; i<profiles.size(); i++) {
				System.out.println(profiles.get(i).getUsername());
				if(profiles.get(i).getUsername().equals(username)) {
					return true;
				}
			}
		return false;
	}
	
	public boolean checkPassword(String password) {
		System.out.println("Checking Pasword");
			profiles = db.getAllProfiles();
			for(int i=0; i<profiles.size(); i++) {
				if(profiles.get(i).getPassword().equals(password)) {
					return true;
				}
			
			}
		return false;
	}
	
	public boolean Register (String firstName, String lastName, String username, String email, String password) {
		int id = -1;
		
		System.out.println("Attempting to insert into database");
		
		//insert profile into DB
		String profileImage = "_view/profilepicture.jpg";
		
		id = db.insertProfileIntoProfileTable(firstName, lastName, username, email, password, profileImage);
		//check if insertion succeeded 
		if(id!=-1) {
			System.out.println("New profile (ID: " + id + ") successfully added to Profile table.");
			
			return true;
		}
		else {
			System.out.println("Failed to insert new profile (ID:" + id + ") into Profile table.");
			
			return false;
		}
	}
}
