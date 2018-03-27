package model;

public class Material {
	
	private int id;
	private int modelId;
	private int quantity;
	private String name;
	private String specs;
	
	public Material() {
		
	}
	
	public Material (int id, int modelId, int quantity, String name, String specs) {
		this.id = id;
		this.modelId = modelId;
		this.quantity = quantity;
		this.name = name;
		this.specs = specs;
	}
	
	public void setId(int id) { this.id = id; }
	public void setModelId(int modelId) { this.modelId = modelId; }
	public void setQuantity(int quantity) { this.quantity = quantity; }
	public void setName(String name) { this.name = name; }
	public void setSpecs(String specs) { this.specs = specs; }
	
	public int getId() { return id; }
	public int getModelId() { return modelId; }
	public int getQuantity() { return quantity;	}
	public String getName() { return name; }
	public String getSpecs() { return specs; }
}
