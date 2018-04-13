package model;

public class Material {
	
	private int id;
	private int modelId;
	private String quantity;
	private String name;
	private String description;
	private String buildTime;
	private String cost;
	
	public Material() {
		
	}
	
	public Material (int id, int modelId, String name, String quantity, String cost, String buildTime, String description) {
		this.id = id;
		this.modelId = modelId;
		this.quantity = quantity;
		this.name = name;
		this.buildTime = buildTime;
		this.description = description;
		this.cost = cost;
	}
	
	public void setId(int id) { this.id = id; }
	public void setModelId(int modelId) { this.modelId = modelId; }
	public void setQuantity(String quantity) { this.quantity = quantity; }
	public void setName(String name) { this.name = name; }
	public void setDescription(String description) { this.description = description; }
	public void setBuildTime(String buildTime) { this.buildTime = buildTime; }
	public void setCost(String cost) { this.cost = cost; }
	
	public int getId() { return id; }
	public int getModelId() { return modelId; }
	public String getQuantity() { return quantity;	}
	public String getName() { return name; }
	public String getDescription() { return description; }
	public String getBuildTime() { return buildTime; }
	public String getCost() { return cost; }
}
