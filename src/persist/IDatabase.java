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
	public List<PhysicalModel> findModelsByProfileId(int profileId);
	
	//finding users
	public List<Profile> findProfileByDatabaseTitle(String title);
	public Profile findProfileByProfileId(int profileId);
	
	//creating models
	public int insertModelIntoPhysicalModelTable(String title, String decription, String thumbnail,
			String engPrinciple, String citation, Category category, String procedure);
	public int insertMaterialIntoMaterialTable(int modelId, String name, int quantity, String cost, String buildTime, String description);
	public int insertKeywordIntoKeywordTable(int modelId, String word);
	public int insertApplicationIntoApplicationTable(int modelId, String beforeClass, String beforeImage,
			String duringClass, String duringImage);
	public int insertRatingIntoRatingTable(int modelId, int rate, String comment);
	
}
