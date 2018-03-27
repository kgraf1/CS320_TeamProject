package model;

public class Rating {
	
	private int id;
	private int modelId;
	private int rate;
	private String comment;
	
	public Rating () {
		
	}
	
	public Rating (int id, int modelId, int rate, String comment) {
		this.id = id;
		this.modelId = modelId;
		this.rate = rate;
		this.comment = comment;
	}
	
	public void setId(int id) { this.id = id; }
	public int getId() { return id; }

	public void setModelId(int modelId) { this.modelId = modelId; }
	public int getModelId() { return modelId; }
	
	public void setRate(int rate) { this.rate = rate; }
	public int getRate() { return rate; }
	
	public void setComment(String comment) { this.comment = comment; }
	public String getComment() { return comment; }
}
