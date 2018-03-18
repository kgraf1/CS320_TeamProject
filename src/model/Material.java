package model;

public class Material {
	
	private int quantity;
	private String name;
	private String specs;
	
	public Material (int quantity, String name, String specs) {
		this.quantity = quantity;
		this.name = name;
		this.specs = specs;
	}
	
	public void setQuantity(int quantity) { this.quantity = quantity; }
	public void setName(String name) { this.name = name; }
	public void setSpecs(String specs) { this.specs = specs; }
	
	public int getQuantity() { return quantity;	}
	public String getName() { return name; }
	public String getSpecs() { return specs; }
}
