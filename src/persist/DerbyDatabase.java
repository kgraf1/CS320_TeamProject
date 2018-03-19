package persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Profile;
import model.PhysicalModel;

public class DerbyDatabase {
	
	//Is now implemented only to work with a fake database
	//needs to be changed in the future to incorporate the real derby database
	public void loadInitialData() throws SQLException {
		List<Profile> profileList;
		List<PhysicalModel> physicalModelList;
		
		try {
			profileList = InitialData.getProfiles();
			//physicalModelList = InitialData.getPhysicalModels();
		} catch (IOException e) {
			throw new SQLException("Couldn't read initial data", e);
		}
	}
	
	
	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		DerbyDatabase db = new DerbyDatabase();
		//db.createTables();
			
		System.out.println("Loading initial data...");
		try {
			db.loadInitialData();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
			
		System.out.println("Success!");
	}
}
