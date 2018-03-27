package modelTest;

import static org.junit.Assert.*;
import model.Rating;
import org.junit.Before;
import org.junit.Test;

public class RatingTest {

	private Rating rating;
	
	@Before
	public void setUp() throws Exception {
		rating = new Rating();
	}

	//Testing the constructor
	@Test
	public void testRating() {
		rating = new Rating (5, 7, 3, "comment");
		
		assertTrue(rating.getId() == 5);
		assertTrue(rating.getModelId() == 7);
		assertTrue(rating.getRate() == 3);
		assertTrue(rating.getComment().compareTo("comment") == 0);
	}

	//Testing the getters and setters
	@Test
	public void testId() {
		rating.setId(44);
		assertTrue(rating.getId() == 44);
	}
	
	@Test
	public void testModelId() {
		rating.setModelId(55);
		assertTrue(rating.getModelId() == 55);
	}
	
	@Test
	public void testRate() {
		rating.setRate(4);
		assertTrue(rating.getRate() == 4);
	}

	@Test
	public void testComment() {
		rating.setComment("this is the comment");
		assertTrue(rating.getComment().compareTo("this is the comment") == 0);
	}
}
