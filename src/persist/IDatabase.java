package persist;

import model.PhysicalModel;
import model.Rating;
import model.Application;
import model.Category;
import model.Material;
import model.Profile;

import java.util.List;

public interface IDatabase {
	//finding models
	public List<PhysicalModel> findModelsByProfileFirstOrLastName(String name);
	public List<PhysicalModel> findModelsByTitle(String title);
	public List<PhysicalModel> findModelsByCategory(String category);
	public List<PhysicalModel> findModelsByKeyword(String keyword);
	public List<PhysicalModel> findModelsByMaterialName(String materialName);
	
	//finding users
	public List<Profile> findProfileByDatabaseTitle(String title);
	
	//creating models
	public PhysicalModel insertModel(String title, List<String> procedureList, List<String> keywords, String decription,
			String thumbnail, String engPrinciple, String citation, Application application, List<Rating> ratings,
			List<Material> materialList, Category category);
	
}
