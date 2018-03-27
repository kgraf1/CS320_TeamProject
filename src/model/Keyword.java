package model;

public class Keyword {
	
	private int id;
	private int modelId;
	private String word;
	
	public Keyword() {
		
	}
	
	public Keyword(int id, int modelId, String word) {
		this.id = id;
		this.modelId = modelId;
		this.word = word;
	}
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public int getModelId() { return modelId; }
	public void setModelId(int modelId) { this.modelId = modelId; }
	
	public String getWord() { return word; }
	public void setWord(String word) { this.word = word; }
}
