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

public class FakeDatabase implements IDatabase {

	private List<PhysicalModel> physicalModelList;
	private List<Profile> profileList;
	//implement all of the lists needed
	
	public FakeDatabase() {
		profileList = new ArrayList<Profile> ();
		physicalModelList = new ArrayList<PhysicalModel>();
		/*
		construct all of the lists needed
		 */
		// Add initial data
		readInitialData();
		
		System.out.println(profileList.size() + " profiles");
		System.out.println(physicalModelList.size() + " physical models");
	}

	public void readInitialData() {
		try {
			profileList.addAll(InitialData.getProfiles());
			physicalModelList.addAll(InitialData.getPhysicalModels());
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't read initial data", e);
		}
	}
	
	@Override
	public List<PhysicalModel> findModelsByProfileFirstOrLastName(String name) {
		List <PhysicalModel> list = new ArrayList<PhysicalModel> ();
		
		for(PhysicalModel model : physicalModelList) {
			if((model.getProfile().getFirstName()==name) || (model.getProfile().getLastName()==name)) {
				list.add(model);
			}
		}
		return list;
	}
	
	@Override
	public List<PhysicalModel> findModelsByTitle(String title) {
		List<PhysicalModel> list = new ArrayList<PhysicalModel> ();
		
		for(PhysicalModel model : physicalModelList) {
			if(model.getTitle().compareTo(title) == 0) {
				list.add(model);
			}
		}
		
		return list;
	}
	
	@Override
	public List<PhysicalModel> findModelsByCategory(String category) {
		List<PhysicalModel> list = new ArrayList<PhysicalModel> ();
		
		for(PhysicalModel model : physicalModelList) {
			if(model.getCategory().toString() == category) {
				list.add(model);
			}
		}
		
		return list;
	}
	
	@Override
	public List<PhysicalModel> findModelsByKeyword(String keyword) {
		List<PhysicalModel> list = new ArrayList<PhysicalModel> ();
		
		for(PhysicalModel model : physicalModelList) {
			String [] keywords = model.getKeywords();
			for(int i =0; i<keywords.length; i++) {
				if(keywords[i] == keyword) {
					list.add(model);
				}
			}
		}
		
		return list;
	}
	
	@Override
	public List<PhysicalModel> findModelsByMaterialName(String materialName) {
		List<PhysicalModel> list = new ArrayList<PhysicalModel> ();
		
		for(PhysicalModel model : physicalModelList) {
			for(int i =0; i<model.getMaterialList().size(); i++) {
				if(materialName.equals(model.getMaterialList().get(i).getName())) {
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
