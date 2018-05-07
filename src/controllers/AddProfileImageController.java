package controllers;



import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.FakeDatabase;
import persist.IDatabase;
import model.Profile;

public class AddProfileImageController {
	
	private IDatabase db = null;
	
	public AddProfileImageController() {
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
	
	public boolean create(int profileId, String profileImage) {
		System.out.println("Create from AddProfileImageController is being called");
	
		Profile profile = null;
		
		// insert the application into DB
		profile = db.addProfileImage(profileId, profileImage);
		
		// check if the insertion succeeded
		if (profile == null)
		{
			System.out.println("New profile image (ID: " +  profileId + ") successfully added to Application table.");
			
			return true;
		}
		else
		{			
			System.out.println("Failed to insert new profile image (ID: " + profileId + ") into Application table: id = -1");
			
			return false;
		}
	}
}