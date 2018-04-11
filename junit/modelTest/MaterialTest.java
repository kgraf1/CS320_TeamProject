package modelTest;

import static org.junit.Assert.*;

import model.Material;

import org.junit.Test;
import org.junit.Before;

public class MaterialTest {

	private Material material;
	
	@Before
	public void setUp() {
		material = new Material();
	}
	
	//Testing the Constructor
	@Test
	public void testConstructor() {
		material = new Material(5, 20, "The name", "4", "4.99", "4 hours", "description");
		
		assertTrue(material.getId() == 5);
		assertTrue(material.getModelId() == 20);
		assertTrue(material.getQuantity().equals("4"));
		assertTrue(material.getName().compareTo("The name") == 0);
		assertTrue(material.getDescription().compareTo("description") == 0);
		assertTrue(material.getCost().compareTo("4.99") == 0);
		assertTrue(material.getBuildTime().compareTo("4 hours") == 0);
	}
	
	//Testing getters and setters
	@Test
	public void testId() {
		material.setId(70);
		assertTrue(material.getId() == 70);
	}
	
	@Test
	public void testModelId() {
		material.setModelId(55);
		assertTrue(material.getModelId() == 55);
	}
	
	@Test
	public void testQuantity() {
		material.setQuantity("6");
		assertTrue(material.getQuantity().equals("6"));
	}
	
	@Test
	public void testName() {
		material.setName("I am the NAME");
		assertTrue(material.getName().compareTo("I am the NAME") == 0);
	}
	
	@Test
	public void testDescrption() {
		material.setDescription("I am the DESCRIPTION");
		assertTrue(material.getDescription().compareTo("I am the DESCRIPTION") == 0);
	}
	
	@Test
	public void testCost() {
		material.setCost("I am the COST");
		assertTrue(material.getCost().compareTo("I am the COST") == 0);
	}
	
	@Test
	public void testBuildTime() {
		material.setBuildTime("I am the BUILDTIME");
		assertTrue(material.getBuildTime().compareTo("I am the BUILDTIME") == 0);
	}
}
