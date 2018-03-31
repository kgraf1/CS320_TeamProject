package persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.PhysicalModel;
import model.Profile;
import model.Category;
import model.Keyword;
import model.Rating;
import model.Material;
import model.Application;

public class InitialData {
	
	public static List<Profile> getProfiles() throws IOException {
		List<Profile> profileList = new ArrayList<Profile>();
		ReadCSV readProfileList = new ReadCSV("profiles.csv");
		try {
			//auto-generated primary key for profile table
			Integer profileId = 1;
			while(true) {
				List<String> tuple = readProfileList.next();
				if(tuple == null) {
					break;
				}
				
				Iterator<String> i = tuple.iterator();
				Profile profile = new Profile();
				profile.setId(profileId++);
				profile.setUsername(i.next());
				profile.setPassword(i.next());
				profile.setEmail(i.next());
				profile.setFirstName(i.next());
				profile.setLastName(i.next());
				
				profileList.add(profile);
			}
			return profileList;
		} finally {
			readProfileList.close();
		}
	}
	
	public static List<PhysicalModel> getPhysicalModels() throws IOException {
		List<PhysicalModel> models = new ArrayList<PhysicalModel>();
		ReadCSV readPhysicalModels = new ReadCSV("physicalModels.csv");
		try {
			// auto-generated primary key for physical model table
			Integer modelId = 1;
			while (true) {
				List<String> tuple = readPhysicalModels.next();
				if (tuple == null) {
					break;
				}
				
				Iterator<String> i = tuple.iterator();
				PhysicalModel model = new PhysicalModel();
				model.setId(modelId++);
				model.setProfileId(Integer.parseInt(i.next()));
				model.setTitle(i.next());
				model.setDescription(i.next());
				model.setThumbnail(i.next());
				model.setEngPrinciple(i.next());
				model.setCitation(i.next());
				model.setCategory(Category.valueOf(i.next().toUpperCase()));
				model.setProcedure(i.next());
				
				models.add(model);
			}
			return models;
		} finally {
			readPhysicalModels.close();
		}
	}
	
	public static List<Keyword> getKeywords() throws IOException {
		List<Keyword> keywords = new ArrayList<Keyword>();
		ReadCSV readKeywordList = new ReadCSV("keywords.csv");
		try {
			//auto-generated primary key for keywords table
			Integer keywordId = 1;
			while(true) {
				List<String> tuple = readKeywordList.next();
				if(tuple == null) {
					break;
				}
				
				Iterator<String> i = tuple.iterator();
				Keyword keyword = new Keyword();
				keyword.setId(keywordId++);
				keyword.setModelId(Integer.parseInt(i.next()));
				keyword.setWord(i.next());
				
				keywords.add(keyword);
			}
			return keywords;
		} finally {
			readKeywordList.close();
		}
	}
	
	public static List<Rating> getRatings() throws IOException {
		List<Rating> ratings = new ArrayList<Rating>();
		ReadCSV readRatingList = new ReadCSV("ratings.csv");
		try {
			//auto-generated primary key for ratings table
			Integer ratingId = 1;
			while(true) {
				List<String> tuple = readRatingList.next();
				if(tuple == null) {
					break;
				}
				
				Iterator<String> i = tuple.iterator();
				Rating rating = new Rating();
				rating.setId(ratingId++);
				rating.setModelId(Integer.parseInt(i.next()));
				rating.setRate(Integer.parseInt(i.next()));
				rating.setComment(i.next());
				
				ratings.add(rating);
			}
			return ratings;
		} finally {
			readRatingList.close();
		}
	}

	public static List<Material> getMaterials() throws IOException {
		List<Material> materials = new ArrayList<Material>();
		ReadCSV readMaterialList = new ReadCSV("materials.csv");
		try {
			//auto-generated primary key for materials table
			Integer materialId = 1;
			while(true) {
				List<String> tuple = readMaterialList.next();
				if(tuple == null) {
					break;
				}
				
				Iterator<String> i = tuple.iterator();
				Material material = new Material();
				material.setId(materialId++);
				material.setModelId(Integer.parseInt(i.next()));
				material.setQuantity(Integer.parseInt(i.next()));
				material.setName(i.next());
				material.setSpecs(i.next());
				
				materials.add(material);
			}
			return materials;
		} finally {
			readMaterialList.close();
		}
	}
	
	public static List<Application> getApplications() throws IOException {
		List<Application> applications = new ArrayList<Application>();
		ReadCSV readApplicationList = new ReadCSV("applications.csv");
		try {
			//auto-generated primary key for application table
			Integer applicationId = 1;
			while(true) {
				List<String> tuple = readApplicationList.next();
				if(tuple == null) {
					break;
				}
				
				Iterator<String> i = tuple.iterator();
				Application application = new Application();
				application.setId(applicationId++);
				application.setModelId(Integer.parseInt(i.next()));
				application.setBeforeClass(i.next());
				application.setBeforeImage(i.next());
				application.setDuringClass(i.next());
				application.setDuringImage(i.next());
				
				applications.add(application);
			}
			return applications;
		} finally {
			readApplicationList.close();
		}
	}
}

