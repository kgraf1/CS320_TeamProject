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
			for(int i=0; i<profiles.size(); i++) {
				if(((profiles.get(i).getFirstName()==name)||(profiles.get(i).getLastName()==name) && (profiles.get(i).getId()==model.getProfileId()))) {
						list.add(model);
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
			if(model.getCategory().equals(category)) {
				list.add(model);
			}
		}
		return list;
	}
	
	@Override
	public List<PhysicalModel> findModelsByKeyword(String keyword) {
		List<PhysicalModel> list = new ArrayList<PhysicalModel> ();
		
		for(PhysicalModel model : physicalModels) {
			for(int i =0; i<keywords.size(); i++) {
				if((keywords.get(i).getWord()==keyword) && (model.getId()==keywords.get(i).getModelId())) {
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
				if((materials.get(i).getName()==materialName) && (materials.get(i).getModelId()==model.getId())){
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
	public PhysicalModel insertModel(String title, List<String> procedureList, List<String> keywords, String decription,
		String thumbnail, String engPrinciple, String citation, Application application, List<Rating> ratings,
		List<Material> materialList, Category category) {
		return null;
	}
		
}
