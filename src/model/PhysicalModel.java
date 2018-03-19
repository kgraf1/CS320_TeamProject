package model;

import java.util.List;

public class PhysicalModel {
	
	private int id;
	private String title;
	private int procedureListId;
	private int keywordsId;
	private String decription;
	private String thumbnail;
	private String engPrinciple;
	private String citation;
	private Application application;
	private int ratingsId;
	private int materialListId;
	private Category category;
	
	public PhysicalModel() {
		
	}
	
	public PhysicalModel(int id, String title, int procedureListId, int keywordsId, String decription,
			String thumbnail, String engPrinciple, String citation, Application application, int ratingsId,
			int materialListId, Category category) {
		this.id = id;
		this.title = title;
		this.procedureListId = procedureListId;
		this.keywordsId = keywordsId;
		this.decription = decription;
		this.thumbnail = thumbnail;
		this.engPrinciple = engPrinciple;
		this.citation = citation;
		this.application = application;
		this.ratingsId = ratingsId;
		this.materialListId = materialListId;
		this.category = category;
	}

	public void setId(int id) { this.id = id; }
	public int getId() { return id; }
	
	public void setTitle(String title) { this.title = title; }
	public String getTitle() { return title; }
	
	public void setProcedureListId(int procedureListId) { this.procedureListId = procedureListId; }
	public int getProcedureListId() { return procedureListId; }
	
	public void setCategory(Category category) { this.category = category; }
	public Category getCategory() { return category; }
	
	public void setKeywordsId(int keywordsId) { this.keywordsId = keywordsId; }
	public int getKeywordsId() { return keywordsId; }
	
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
	
	public int getRatingsId() { return ratingsId; }
	public void setRatingsId(int ratingsId) { this.ratingsId = ratingsId; }
	
	public int getMaterialListId() { return materialListId; }
	public void setMaterialListId(int materialListId) { this.materialListId = materialListId; }
	
	//might move this to another class
	/*public double getAverageRating() {
		double average = 0;
		
		for(int i = 0; i < ratings.size(); i++) {
			average = average + ratings.get(i).getRate();
		}
		
		return average / (double)(ratings.size());
	}*/
	
}
