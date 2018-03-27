package modelTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import model.Application;

public class ApplicationTest {

	private Application application;
	
	@Before
	public void setUp() {
		application = new Application();
	}
	
	//Testing the constructor
	@Test
	public void testConstructor() {
		application = new Application(5, 9, "beforeClass", "beforeImage", "duringClass", "duringImage");
		
		assertTrue(application.getId() == 5);
		assertTrue(application.getModelId() == 9);
		assertTrue(application.getBeforeClass().compareTo("beforeClass") == 0);
		assertTrue(application.getBeforeImage().compareTo("beforeImage") == 0);
		assertTrue(application.getDuringClass().compareTo("duringClass") == 0);
		assertTrue(application.getDuringImage().compareTo("duringImage") == 0);
	}
	
	//Testing the getters and setters
	@Test
	public void testId() {
		application.setId(20);
		assertTrue(application.getId() == 20);
	}
	
	@Test
	public void testModelId() {
		application.setModelId(25);
		assertTrue(application.getModelId() == 25);
	}
	
	@Test
	public void testBeforeClass() {
		application.setBeforeClass("This is before class");
		assertTrue(application.getBeforeClass().compareTo("This is before class") == 0);
	}

	@Test
	public void testBeforeImage() {
		application.setBeforeImage("This is before image");
		assertTrue(application.getBeforeImage().compareTo("This is before image") == 0);
	}

	@Test
	public void testDuringClass() {
		application.setDuringClass("This is during class");
		assertTrue(application.getDuringClass().compareTo("This is during class") == 0);
	}
	
	@Test
	public void testDuringImage() {
		application.setDuringImage("This is during image");
		assertTrue(application.getDuringImage().compareTo("This is during image") == 0);
	}


}
