package model;

public class Application {

	private int id;				//this one
	private int modelId;		//this one
	private String beforeClass;
	private String beforeImage;
	private String duringClass;
	private String duringImage;
	
	public Application() {
		
	}
	
	public Application(int id, int modelId, String beforeClass, String beforeImage, String duringClass, String duringImage) {
		this.id = id;
		this.modelId = modelId;
		this.beforeClass = beforeClass;
		this.beforeImage = beforeImage;
		this.duringClass = duringClass;
		this.duringImage = duringImage;
	}
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public int getModelId() { return modelId; }
	public void setModelId(int modelId) { this.modelId = modelId; }
	
	public String getBeforeClass() { return beforeClass; }
	public void setBeforeClass(String beforeClass) { this.beforeClass = beforeClass; }
	
	public String getBeforeImage() { return beforeImage; }
	public void setBeforeImage(String beforeImage) { this.beforeImage = beforeImage; }
	
	public String getDuringClass() { return duringClass; }
	public void setDuringClass(String duringClass) { this.duringClass = duringClass; }
	
	public String getDuringImage() { return duringImage; }
	public void setDuringImage(String duringImage) { this.duringImage = duringImage; }
	
	
}
