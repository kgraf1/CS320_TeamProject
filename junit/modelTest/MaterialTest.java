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
		material = new Material(5, 20, 4, "The name", "specs");
		
		assertTrue(material.getId() == 5);
		assertTrue(material.getModelId() == 20);
		assertTrue(material.getQuantity() == 4);
		assertTrue(material.getName().compareTo("The name") == 0);
		assertTrue(material.getSpecs().compareTo("specs") == 0);
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
		material.setQuantity(6);
		assertTrue(material.getQuantity() == 6);
	}
	
	@Test
	public void testName() {
		material.setName("I am the NAME");
		assertTrue(material.getName().compareTo("I am the NAME") == 0);
	}
	
	@Test
	public void testSpecs() {
		material.setSpecs("I am the SPECS");
		assertTrue(material.getSpecs().compareTo("I am the SPECS") == 0);
	}
}