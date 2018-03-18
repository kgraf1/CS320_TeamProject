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
		rating = new Rating (3, "comment");
		
		assertTrue(rating.getRate() == 3);
		assertTrue(rating.getComment().compareTo("comment") == 0);
	}

	//Testing the getters and setters
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
