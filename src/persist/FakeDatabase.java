package persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Application;
import model.Category;
import model.Material;
import model.PhysicalModel;
import model.Profile;
import model.Rating;
import model.Keyword;

public class FakeDatabase implements IDatabase {

	private List<Profile> profiles;
	private List<PhysicalModel> physicalModels;
	private List<Keyword> keywords;
	private List<Rating> ratings;
	private List<Material> materials;
	private List<Application> applications;
	
	public FakeDatabase() {
		profiles = new ArrayList<Profile> ();
		physicalModels = new ArrayList<PhysicalModel>();
		keywords = new ArrayList<Keyword>();
		ratings = new ArrayList<Rating>();
		materials = new ArrayList<Material>();
		applications = new ArrayList<Application>();
		
		// Add initial data
		readInitialData();
		
		System.out.println(profiles.size() + " profiles");
		System.out.println(physicalModels.size() + " physical models");
		System.out.println(keywords.size() + " keywords");
		System.out.println(ratings.size() + " ratings");
		System.out.println(materials.size() + " materials");
		System.out.println(applications.size() + " applications");
	}

	public void readInitialData() {
		try {
			profiles.addAll(InitialData.getProfiles());
			physicalModels.addAll(InitialData.getPhysicalModels());
			keywords.addAll(InitialData.getKeywords());
			ratings.addAll(InitialData.getRatings());
			materials.addAll(InitialData.getMaterials());
			applications.addAll(InitialData.getApplications());
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't read initial data", e);
		}
	}
	
	@Override
	public List<PhysicalModel> findModelsByProfileId(Long id) {
		return null;
	}
	
	@Override
	public List<PhysicalModel> findModelsByTitle(String title) {
		List<PhysicalModel> list = new ArrayList<PhysicalModel> ();
		
		for(PhysicalModel model : physicalModels) {
			if(model.getTitle().compareTo(title) == 0) {
				list.add(model);
			}
		}
		
		return list;
	}
	
	@Override
	public List<PhysicalModel> findModelsByCategory(Category category) {
		List<PhysicalModel> list = new ArrayList<PhysicalModel> ();
		
		for(PhysicalModel model : physicalModels) {
			if(model.getCategory() == category) {
				list.add(model);
			}
		}
		
		return list;
	}
	
	@Override
	public List<PhysicalModel> findModelsByKeyword(String keyword) {
		/*List<PhysicalModel> list = new ArrayList<PhysicalModel> ();
		
		for(PhysicalModel model : physicalModelList) {
			if(model.getKeywords().contains(keyword)) {
				list.add(model);
			}
		}
		
		return list;
		*/
		return null;
	}
	
	@Override
	public List<PhysicalModel> findModelsByMaterialName(String materialName) {
		/*List<PhysicalModel> list = new ArrayList<PhysicalModel> ();
		
		for(PhysicalModel model : physicalModelList) {
			for(Material material : model.getMaterialList()) {
				if(material.getName().compareTo(materialName) == 0) {
					list.add(model);
				}
			}
		}
		
		return list;
		*/
		return null;
	}
		
	@Override
	public List<Profile> findProfileByDatabaseTitle(String title) {
		return null;
	}
		
	@Override
	public int insertModelIntoPhysicalModelTable(String title, String decription, String thumbnail,
			String engPrinciple, String citation, Category category, String procedure) {

		int id = 1;
		
		if(physicalModels.size() > 0) {
			id = physicalModels.get(physicalModels.size() - 1).getId() + 1;
		}
		
		int profileId = profiles.get(profiles.size() - 1).getId() + 1;
		
		PhysicalModel model = new PhysicalModel(id, profileId, title, decription, thumbnail, engPrinciple, citation,
									category, procedure);
		
		physicalModels.add(model);
		
		return model.getId();
	}
		
	@Override
	public int insertMaterialIntoMaterialTable(int modelId, int quantity, String name, String specs) {

		int id = 1;
		
		if(materials.size() > 0) {
			id = materials.get(materials.size() - 1).getId() + 1;
		}
		
		Material material = new Material(id, modelId, quantity, name, specs);
		
		materials.add(material);
		
		return material.getId();
	}
	
	@Override
	public int insertKeywordIntoKeywordTable(int modelId, String word) {

		int id = 1;
		
		if(keywords.size() > 0) {
			id = keywords.get(keywords.size() - 1).getId() + 1;
		}
		
		Keyword keyword = new Keyword(id, modelId, word);
		
		keywords.add(keyword);
		
		return keyword.getId();
	}
	
	@Override
	public int insertApplicationIntoApplicationTable(int modelId, String beforeClass, String beforeImage,
			String duringClass, String duringImage) {
		
		int id = 1;
		
		if(applications.size() > 0) {
			id = applications.get(applications.size() - 1).getId() + 1;
		}
		
		Application app = new Application(id, modelId, beforeClass, beforeImage, duringClass, duringImage);
		
		applications.add(app);
		
		return app.getId();
	}
	
	@Override
	public int insertRatingIntoRatingTable(int modelId, int rate, String comment) {

		int id = 1;
		
		if(ratings.size() > 0) {
			id = ratings.get(ratings.size() - 1).getId() + 1;
		}
		
		Rating rating = new Rating(id, modelId, rate, comment);
		
		ratings.add(rating);
		
		return rating.getId();
	}
}
