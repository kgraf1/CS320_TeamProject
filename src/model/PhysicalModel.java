package model;

import java.util.List;

public class PhysicalModel {
	
	private int id;
	private int profileId;
	private String title;
	private String decription;
	private String thumbnail;
	private String engPrinciple;
	private String citation;
	private Category category;
	private String procedure;
	
	public PhysicalModel() {
		
	}
	
	public PhysicalModel(int id, int profileId, String title, String decription, String thumbnail, 
						String engPrinciple, String citation, Category category, String procedure) {
		this.id = id;
		this.profileId = profileId;
		this.title = title;
		this.decription = decription;
		this.thumbnail = thumbnail;
		this.engPrinciple = engPrinciple;
		this.citation = citation;
		this.category = category;
		this.procedure = procedure;
	}

	public void setId(int id) { this.id = id; }
	public int getId() { return id; }
	
	public void setProfileId(int profileId) { this.profileId = profileId; }
	public int getProfileId() { return profileId; }
	
	public void setTitle(String title) { this.title = title; }
	public String getTitle() { return title; }
	
	public void setCategory(Category category) { this.category = category; }
	public Category getCategory() { return category; }
	
	public void setDescription(String description) { this.decription = description; }
	public String getDecription() { return decription; }
	
	public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail; }
	public String getThumbnail() { return thumbnail; }
	
	public void setEngPrinciple(String engPrinciple) { this.engPrinciple = engPrinciple; }
	public String getEngPrinciple() { return engPrinciple; }
	
	public String getCitation() { return citation; }
	public void setCitation(String citation) { this.citation = citation; }
	
	public String getProcedure() { return procedure; }
	public void setProcedure(String procedure) { this.procedure = procedure; }
	
}
