package modelTest;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import model.Application;
import model.Category;
import model.Material;
import model.PhysicalModel;
import model.Rating;
import modelDB.ModelsByProfileFirstOrLastNameQuery;
import model.Profile;

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
		
		String [] keywords = {"hello", "these", "are", "keywords"};
		
		Material material1 = new Material (1, 1, 12, "Aluminum", "20mm");
		Material material2 = new Material (2, 1, 5, "Screw", "8 gauge");
		List<Material> MaterialList = new ArrayList<Material>();
		MaterialList.add(material1);
		MaterialList.add(material2);
		
		Application application = new Application (1, 1, "beforeClass", "beforeImage", "duringClass", "duringImage");

		Profile profile = new Profile (1, "testUser", "12345", "test@gmail.com", "Test", "Professor");
		
		model = new PhysicalModel(1, 6, "the title", "the description",
				"the thumbnail", "the engPrinciple", "the citation", Category.DYNAMICS, keywords, MaterialList, application, profile);
		
		assertEquals(model.getId(), 1);
		assertTrue(model.getProfileId() == 6);
		assertTrue(model.getTitle().compareTo("the title") == 0);
		assertTrue(model.getDecription().compareTo("the description") == 0);
		assertTrue(model.getThumbnail().compareTo("the thumbnail") == 0);
		assertTrue(model.getEngPrinciple().compareTo("the engPrinciple") == 0);
		assertTrue(model.getCitation().compareTo("the citation") == 0);
		assertTrue(model.getCategory() == Category.DYNAMICS);
		assertTrue(model.getKeywords()== keywords);
		assertTrue(model.getMaterialList() == MaterialList);
		assertTrue(model.getApplication() == application);
		assertTrue(model.getProfile() == profile);
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
	public void testKeywords () {
		String [] keywords = {"These", "are", "keywords"};
		model.setKeywords(keywords);
		assertTrue(model.getKeywords().equals(keywords));
	}
	
	@Test
	public void testMaterialList () {
		List <Material> MaterialList = new ArrayList<Material>();
		Material material1 = new Material (3, 1, 2, "bulb", "40Watt");
		Material material2 = new Material (4, 1, 5, "hammer", "no specs");
		MaterialList.add(material1);
		MaterialList.add(material2);
		model.setMaterialList(MaterialList);
		assertTrue(model.getMaterialList().equals(MaterialList));
	}
	
	@Test 
	public void testApplication () {
		Application application = new Application(2, 1, "before", "modelPieces", "during", "completeModel");
		model.setApplication(application);
		assertTrue(model.getApplication().equals(application));
	}

	//might be moving to different class
	/*@Test
	public void testGetAverageRating() {
		List<Rating> theList = new ArrayList<Rating> ();
		theList.add(new Rating(4, "Comment"));
		theList.add(new Rating(2, "Comment"));
		theList.add(new Rating(5, "Comment"));
		model.setRatings(theList);
		
		double average = (4 + 2 + 5) / 3.0;
		
		assertTrue(Math.abs(average - model.getAverageRating()) < 0.0001);
	}*/

}
