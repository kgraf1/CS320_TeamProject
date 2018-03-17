package loginregistrationtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class TestLogin {
	boolean setup = false;
	@Before
	public void setUp() {
		 setup = true;
	}
	@Test
	public void testSetup() throws Exception {
		assertTrue(setup);
	}
}
