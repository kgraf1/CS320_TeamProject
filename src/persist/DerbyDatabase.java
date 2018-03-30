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
	public PhysicalModel insertModel(String title, List<String> procedureList, List<String> keywords, String decription,
			String thumbnail, String engPrinciple, String citation, Application application, List<Rating> ratings,
			List<Material> materialList, Category category) { return null; }
}
