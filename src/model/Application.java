package model;

public class Application {

	private String beforeClass;
	private String beforeImage;
	private String duringClass;
	private String duringImage;
	
	
	public Application(String beforeClass, String beforeImage, String duringClass, String duringImage) {
		this.beforeClass = beforeClass;
		this.beforeImage = beforeImage;
		this.duringClass = duringClass;
		this.duringImage = duringImage;
	}
	
	public String getBeforeClass() { return beforeClass; }
	public void setBeforeClass(String beforeClass) { this.beforeClass = beforeClass; }
	
	public String getBeforeImage() { return beforeImage; }
	public void setBeforeImage(String beforeImage) { this.beforeImage = beforeImage; }
	
	public String getDuringClass() { return duringClass; }
	public void setDuringClass(String duringClass) { this.duringClass = duringClass; }
	
	public String getDuringImage() { return duringImage; }
	public void setDuringImage(String duringImage) { this.duringImage = duringImage; }
	
	
}
