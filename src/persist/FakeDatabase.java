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
	
	public FakeDatabase() {
		physicalModelList = new ArrayList<PhysicalModel>();
	
		// Add initial data
		readInitialData();
		
		System.out.println(physicalModelList.size() + " physical models");
	}

	public void readInitialData() {
		try {
			physicalModelList.addAll(InitialData.getPhysicalModels());
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
		
		for(PhysicalModel model : physicalModelList) {
			if(model.getTitle().compareTo(title) == 0) {
				list.add(model);
			}
		}
		
		return list;
	}
	
	@Override
	public List<PhysicalModel> findModelsByCategory(Category category) {
		List<PhysicalModel> list = new ArrayList<PhysicalModel> ();
		
		for(PhysicalModel model : physicalModelList) {
			if(model.getCategory() == category) {
				list.add(model);
			}
		}
		
		return list;
	}
	
	@Override
	public List<PhysicalModel> findModelsByKeyword(String keyword) {
		List<PhysicalModel> list = new ArrayList<PhysicalModel> ();
		
		for(PhysicalModel model : physicalModelList) {
			if(model.getKeywords().contains(keyword)) {
				list.add(model);
			}
		}
		
		return list;
	}
	
	@Override
	public List<PhysicalModel> findModelsByMaterialName(String materialName) {
		List<PhysicalModel> list = new ArrayList<PhysicalModel> ();
		
		for(PhysicalModel model : physicalModelList) {
			for(Material material : model.getMaterialList()) {
				if(material.getName().compareTo(materialName) == 0) {
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
