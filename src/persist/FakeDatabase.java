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
	public List<PhysicalModel> findModelsByProfileFirstOrLastName(String name) {
		List <PhysicalModel> list = new ArrayList<PhysicalModel> ();
		
		
		for(PhysicalModel model : physicalModels) {
			for(Profile profile:profiles) { 
				if(model.getProfileId()==profile.getId()) {
					if((profile.getFirstName().equals(name)) || (profile.getLastName().equals(name))){
						list.add(model);
					}
				}
				
			}
		}
		return list;
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
	public List<PhysicalModel> findModelsByCategory(String category) {
		List<PhysicalModel> list = new ArrayList<PhysicalModel> ();
		

		for(PhysicalModel model : physicalModels) {
			if(model.getCategory().toString().equals(category.toUpperCase())) {
				list.add(model);
			}
		}
		return list;
	}
	
	@Override
	public List<PhysicalModel> findModelsByKeyword(String keyword) {
		List<PhysicalModel> list = new ArrayList<PhysicalModel> ();
		
		for(PhysicalModel model : physicalModels) {
			for(Keyword key: keywords) {
				if((key.getWord().equals(keyword)) && (model.getId()==key.getModelId())) {
					list.add(model);
				}
			}
		}
		
		return list;
	}
	
	@Override
	public List<PhysicalModel> findModelsByMaterialName(String materialName) {
		List<PhysicalModel> list = new ArrayList<PhysicalModel> ();
		
		for(PhysicalModel model : physicalModels) {
			for(int i =0; i<materials.size(); i++) {
				if((materials.get(i).getName().equals(materialName)) && (materials.get(i).getModelId()==model.getId())){
					list.add(model);
				}
				
			}
		}
		return list;
	}
		
	@Override
	public List<Profile> findProfileByDatabaseTitle(String title) {
		return null;
	}
		
	@Override
	public int insertModelIntoPhysicalModelTable(String title, String decription, String thumbnail,
			String engPrinciple, String citation, Category category, String procedure) {

		int id = 1;
		
		System.out.println("In Fake database method");
		
		if(physicalModels.size() > 0) {			
			id = physicalModels.get(physicalModels.size() - 1).getId() + 1;
		}
		
		int profileId = profiles.get(profiles.size() - 1).getId() + 1;
		
		System.out.println("The id is: " + id);
		
		PhysicalModel model = new PhysicalModel(id, profileId, title, decription, thumbnail, engPrinciple, citation,
									category, procedure);
		
		physicalModels.add(model);
		
		return model.getId();
	}
		
	@Override
	public int insertMaterialIntoMaterialTable(int modelId, String name, int quantity, String cost, String buildTime, String description) {

		int id = 1;
	
		if(materials.size() > 0) {
			id = materials.get(materials.size() - 1).getId() + 1;
		}
		
		Material material = new Material(id, modelId, name, quantity, cost, buildTime, description);
		
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
	public int insertProfileIntoProfileTable (String firstName, String lastName, String username, String email, String password) {
		int id = 1;
		
		if(profiles.size()>0) {
			id = profiles.get(profiles.size()-1).getId() + 1;
		}
		
		Profile profile = new Profile(id, username, password, firstName, lastName, email);
		profiles.add(profile);
		
		return profile.getId();
	}
	
	@Override 
	public List<Profile> getAllProfiles(){
		return profiles;
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
