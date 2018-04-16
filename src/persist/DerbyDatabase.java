package persist;

import java.io.IOException;
import java.util.List;

import model.Application;
import model.Category;
import model.Keyword;
import model.Material;
import model.PhysicalModel;
import model.Profile;
import model.Rating;

public class DerbyDatabase implements IDatabase {	
	
	
	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		//DerbyDatabase db = new DerbyDatabase();
		
		//db.createTables();
			
		System.out.println("Loading fake database initial data...");
	
		FakeDatabase fdb = new FakeDatabase();
		
		System.out.println("Success!");
	}
	
	//Jason's methods 

	@Override
	public List<Rating> findRatingsByModelId(int modelId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int insertApplicationIntoApplicationTable(int modelId, String beforeClass, String beforeImage,
			String duringClass, String duringImage) { return 0; }
	
	public int insertKeywordIntoKeywordTable(int modelId, String word) { return 0; }
	
	public int insertMaterialIntoMaterialTable(int modelId, String name, String quantity, String cost, String buildTime, String description) { return 0;}
	
	
	public Profile findProfileByProfileId(int profileId) { return null; }
	
	@Override
	public PhysicalModel findModelByModelId(int modelId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<PhysicalModel> findModelsByProfileId(int profileId) { return null; }
	
	public List<PhysicalModel> findModelsByMaterialName(String materialName) { return null; }
	
	public List<PhysicalModel> findModelsByCategory(Category category) { return null; }
	
	public List<PhysicalModel> findModelsByKeyword(String keyword) { return null; }
	
	//end of Jason's methods
	
	
	//Kate's methods
	@Override
	public List<Material> findMaterialsByModelId(int modelId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Keyword> findKeywordsByModelId(int modelId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override 
	public List<Profile> getAllProfiles(){
		return null;
	}
	
	public int insertModelIntoPhysicalModelTable(String title, String decription, String thumbnail,
			String engPrinciple, String citation, Category category, String procedure) { return 0; }
	
	public List<PhysicalModel> findModelsByTitle(String title) { return null; }
	
	

	@Override
	public List<PhysicalModel> findModelsByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}
	//end of Kate methods
	
	
	//Kaitlyn's methods
	@Override
	public Profile findProfileByModelId(int modelId) {
		//TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Application findApplicationByModelId(int modelId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int insertRatingIntoRatingTable(int modelId, int rate, String comment) { return 0; }

	@Override
	public int insertProfileIntoProfileTable(String firstName, String lastName, String username, String email,
			String password) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<PhysicalModel> findModelsByProfileFirstOrLastName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	//finding models
		public List<PhysicalModel> findModelsByProfileId(Long id) { return null; }
	//end of Kaitlyn's methods

	@Override
	public int findProfileIdByUsername(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertModelIntoPhysicalModelTable(int profileId, String title, String decription, String thumbnail,
			String engPrinciple, String citation, Category category, String procedure) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
	





	
}
