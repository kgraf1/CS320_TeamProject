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
	public List<PhysicalModel> findModelsByProfileId(Long id);
	public List<PhysicalModel> findModelsByTitle(String title);
	public List<PhysicalModel> findModelsByCategory(Category category);
	public List<PhysicalModel> findModelsByKeyword(String keyword);
	public List<PhysicalModel> findModelsByMaterialName(String materialName);
	
	//finding users
	public List<Profile> findProfileByDatabaseTitle(String title);
	
	//creating models
	public int insertModelIntoPhysicalModelTable(String title, String decription, String thumbnail,
			String engPrinciple, String citation, Category category, String procedure);
	public int insertMaterialIntoMaterialTable(int modelId, int quantity, String name, String specs);
	public int insertKeywordIntoKeywordTable(int modelId, String word);
	public int insertApplicationIntoApplicationTable(int modelId, String beforeClass, String beforeImage,
			String duringClass, String duringImage);
	public int insertRatingIntoRatingTable(int modelId, int rate, String comment);
	
}
