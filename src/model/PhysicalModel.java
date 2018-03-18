package model;

import java.util.List;

public class PhysicalModel {
	
	private int id;
	private String title;
	private List<String> procedureList;
	private List<String> keywords;
	private String decription;
	private String thumbnail;
	private String engPrinciple;
	private String citation;
	private Application application;
	private List<Rating> ratings;
	private List<Material> materialList;
	private Category category;
	
	public PhysicalModel() {
		
	}
	
	public PhysicalModel(int id, String title, List<String> procedureList, List<String> keywords, String decription,
			String thumbnail, String engPrinciple, String citation, Application application, List<Rating> ratings,
			List<Material> materialList, Category category) {
		this.id = id;
		this.title = title;
		this.procedureList = procedureList;
		this.keywords = keywords;
		this.decription = decription;
		this.thumbnail = thumbnail;
		this.engPrinciple = engPrinciple;
		this.citation = citation;
		this.application = application;
		this.ratings = ratings;
		this.materialList = materialList;
		this.category = category;
	}

	public void setId(int id) { this.id = id; }
	public int getId() { return id; }
	
	public void setTitle(String title) { this.title = title; }
	public String getTitle() { return title; }
	
	public void setProcedureList(List<String> procedureList) { this.procedureList = procedureList; }
	public List<String> getProcedureList() { return procedureList; }
	
	public void setCategory(Category category) { this.category = category; }
	public Category getCategory() { return category; }
	
	public void setKeywords(List<String> keywords) { this.keywords = keywords; }
	public List<String> getKeywords() { return keywords; }
	
	public void setDescription(String description) { this.decription = description; }
	public String getDecription() { return decription; }
	
	public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail; }
	public String getThumbnail() { return thumbnail; }
	
	public void setEngPrinciple(String engPrinciple) { this.engPrinciple = engPrinciple; }
	public String getEngPrinciple() { return engPrinciple; }
	
	public String getCitation() { return citation; }
	public void setCitation(String citation) { this.citation = citation; }
	
	public Application getApplication() { return application; }
	public void setApplication(Application application) { this.application = application; }
	
	public List<Rating> getRatings() { return ratings; }
	public void setRatings(List<Rating> ratings) { this.ratings = ratings; }
	
	public List<Material> getMaterialList() { return materialList; }
	public void setMaterialList(List<Material> materialList) { this.materialList = materialList; }
	
	public double getAverageRating() {
		double average = 0;
		
		for(int i = 0; i < ratings.size(); i++) {
			average = average + ratings.get(i).getRate();
		}
		
		return average / (double)(ratings.size());
	}
	
}
