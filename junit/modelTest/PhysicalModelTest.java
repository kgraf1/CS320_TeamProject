package modelTest;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import model.Application;
import model.Category;
import model.Material;
import model.PhysicalModel;
import model.Rating;

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
		Application application = new Application();
		
		model = new PhysicalModel(1, "the title", 2, 3, "the description",
				"the thumbnail", "the engPrinciple", "the citation", application, 4,
				5, Category.DYNAMICS);
		
		assertEquals(model.getId(), 1);
		assertTrue(model.getTitle().compareTo("the title") == 0);
		assertTrue(model.getProcedureListId() == 2);
		assertTrue(model.getKeywordsId() == 3);
		assertTrue(model.getDecription().compareTo("the description") == 0);
		assertTrue(model.getThumbnail().compareTo("the thumbnail") == 0);
		assertTrue(model.getEngPrinciple().compareTo("the engPrinciple") == 0);
		assertTrue(model.getCitation().compareTo("the citation") == 0);
		assertTrue(model.getApplication() == application);
		assertTrue(model.getRatingsId() == 4);
		assertTrue(model.getMaterialListId() == 5);
		assertTrue(model.getCategory() == Category.DYNAMICS);
	}

	//Testing getters and setters
	@Test
	public void testId() {
		model.setId(5);
		assertTrue(model.getId() == 5);
	}

	@Test
	public void testTitle() {
		model.setTitle("This is the title");
		assertTrue(model.getTitle().compareTo("This is the title") == 0);
	}

	@Test
	public void testProcedureList() {
		model.setProcedureListId(10);
		assertTrue(model.getProcedureListId() == 10);
	}

	@Test
	public void testCategory() {
		model.setCategory(Category.CONSTRUCTION);
		assertEquals(model.getCategory(), Category.CONSTRUCTION);
	}

	@Test
	public void testKeywords() {
		model.setKeywordsId(11);
		assertTrue(model.getKeywordsId() == 11);
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
	public void testApplication() {
		Application application = new Application();
		
		model.setApplication(application);
		assertTrue(model.getApplication() == application);
	}

	@Test
	public void testRatings() {
		model.setRatingsId(12);
		assertTrue(model.getRatingsId() == 12);
	}
	
	@Test
	public void testMaterialList() {
		model.setMaterialListId(13);
		assertTrue(model.getMaterialListId() == 13);
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
