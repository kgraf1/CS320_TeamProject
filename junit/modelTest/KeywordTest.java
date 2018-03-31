package modelTest;

import model.Keyword; 

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class KeywordTest {

	private Keyword keyword;
	
	@Before
	public void setUp() {
		keyword = new Keyword();
	}
	
	//Testing the constructor
	@Test
	public void testKeyword() {
		keyword = new Keyword(4, 5, "keyword");
		
		assertTrue(keyword.getId() == 4);
		assertTrue(keyword.getModelId() == 5);
		assertTrue(keyword.getWord().compareTo("keyword") == 0);
	}
	
	//Testing the getters and setters
	@Test
	public void testId() {
		keyword.setId(55);
		assertTrue(keyword.getId() == 55);
	}
	
	@Test
	public void testModelId() {
		keyword.setModelId(75);
		assertTrue(keyword.getModelId() == 75);
	}
	
	@Test
	public void testWord() {
		keyword.setWord("This is the word");
		assertTrue(keyword.getWord().compareTo("This is the word") == 0);
	}

}
