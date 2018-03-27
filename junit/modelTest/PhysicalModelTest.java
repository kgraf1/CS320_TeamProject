package modelTest;

import static org.junit.Assert.*;

import model.Category;
import model.PhysicalModel;

import org.junit.Test;
import org.junit.Before;

public class PhysicalModelTest {

	private PhysicalModel model;
	
	@Before
	public void setUp() {
		model = new PhysicalModel();
	}
	
	//Testing the constructor
	@Test
	public void testPhysicalModel() {

		model = new PhysicalModel(1, 6, "the title", "the description",
				"the thumbnail", "the engPrinciple", "the citation", Category.DYNAMICS, "the procedure");
		
		assertEquals(model.getId(), 1);
		assertTrue(model.getProfileId() == 6);
		assertTrue(model.getTitle().compareTo("the title") == 0);
		assertTrue(model.getDecription().compareTo("the description") == 0);
		assertTrue(model.getThumbnail().compareTo("the thumbnail") == 0);
		assertTrue(model.getEngPrinciple().compareTo("the engPrinciple") == 0);
		assertTrue(model.getCitation().compareTo("the citation") == 0);
		assertTrue(model.getCategory() == Category.DYNAMICS);
		assertTrue(model.getProcedure().compareTo("the procedure") == 0);
	}

	//Testing getters and setters
	@Test
	public void testId() {
		model.setId(5);
		assertTrue(model.getId() == 5);
	}

	@Test
	public void testProfileId() {
		model.setProfileId(55);
		assertTrue(model.getProfileId() == 55);
	}
	
	@Test
	public void testTitle() {
		model.setTitle("This is the title");
		assertTrue(model.getTitle().compareTo("This is the title") == 0);
	}

	@Test
	public void testCategory() {
		model.setCategory(Category.CONSTRUCTION);
		assertEquals(model.getCategory(), Category.CONSTRUCTION);
	}

	@Test
	public void testDescription() {
		model.setDescription("This is the description");
		assertTrue(model.getDecription().compareTo("This is the description") == 0);
	}

	@Test
	public void testThumbnail() {
		model.setThumbnail("This is the thumbnail");
		assertTrue(model.getThumbnail().compareTo("This is the thumbnail") == 0);
	}

	@Test
	public void testEngPrinciple() {
		model.setEngPrinciple("This is the engPrinciple");
		assertTrue(model.getEngPrinciple().compareTo("This is the engPrinciple") == 0);
	}

	@Test
	public void testCitation() {
		model.setCitation("This is the citation");
		assertTrue(model.getCitation().compareTo("This is the citation") == 0);
	}

	@Test
	public void testProcedure() {
		model.setProcedure("This is the procedure");
		assertTrue(model.getProcedure().compareTo("This is the procedure") == 0);
	}

}
