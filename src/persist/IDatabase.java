package persist;

import model.PhysicalModel;
import model.Rating;
import model.Keyword;
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
	public PhysicalModel findModelByModelId(int modelId);
	
	//finding users
	public List<Profile> findProfileByDatabaseTitle(String title);
	public Profile findProfileByProfileId(int profileId);
	public int findProfileIdByUsername(String username);
	
	//creating models
	public int insertModelIntoPhysicalModelTable(int profileId, String title, String decription, String thumbnail,
			String engPrinciple, String citation, Category category, String procedure);
	public int insertMaterialIntoMaterialTable(int modelId, String name, String quantity, String cost, String buildTime, String description);
	public int insertKeywordIntoKeywordTable(int modelId, String word);
	public int insertApplicationIntoApplicationTable(int modelId, String beforeClass, String beforeImage,
			String duringClass, String duringImage);
	public int insertProfileIntoProfileTable(String firstName, String lastName, String username, String email, String password);
	public int insertRatingIntoRatingTable(int modelId, int rate, String comment);
	public List<Profile> getAllProfiles();
	
	
	//getting other model information 
	public List<Keyword> findKeywordsByModelId(int modelId);
	public List<Material> findMaterialsByModelId(int modelId);
	public Application findApplicationByModelId(int modelId);
	public List<Rating> findRatingsByModelId(int modelId);
	public Profile findProfileByModelId(int modelId);
}
