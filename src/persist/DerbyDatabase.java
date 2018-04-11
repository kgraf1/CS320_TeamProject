package persist;

import java.io.IOException;
import java.util.List;

import model.Application;
import model.Category;
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
	
	//finding models
	public List<PhysicalModel> findModelsByProfileId(Long id) { return null; }
	public List<PhysicalModel> findModelsByTitle(String title) { return null; }
	public List<PhysicalModel> findModelsByCategory(Category category) { return null; }
	public List<PhysicalModel> findModelsByKeyword(String keyword) { return null; }
	public List<PhysicalModel> findModelsByMaterialName(String materialName) { return null; }
	
	//finding users
	public List<Profile> findProfileByDatabaseTitle(String title) { return null; }
	
	//creating models
	public int insertModelIntoPhysicalModelTable(String title, String decription, String thumbnail,
			String engPrinciple, String citation, Category category, String procedure) { return 0; }
	
	public int insertMaterialIntoMaterialTable(int modelId, String name, int quantity, String cost, String buildTime, String description) { return 0;}
	public int insertKeywordIntoKeywordTable(int modelId, String word) { return 0; }
	public int insertApplicationIntoApplicationTable(int modelId, String beforeClass, String beforeImage,
			String duringClass, String duringImage) { return 0; }
	public int insertRatingIntoRatingTable(int modelId, int rate, String comment) { return 0; }


	@Override
	public List<PhysicalModel> findModelsByProfileFirstOrLastName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PhysicalModel> findModelsByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertProfileIntoProfileTable(String firstName, String lastName, String username, String email,
			String password) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override 
	public List<Profile> getAllProfiles(){
		return null;
	}
}
