package modelTest;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import model.Profile;
import org.junit.Before;
import org.junit.Test;

public class ProfileTest {

	private Profile profile;
	
	@Before
	public void setUp() throws Exception {
		profile = new Profile();
	}

	//Testing the constructor
	@Test
	public void testProfile() {
		List<Integer> modelList = new ArrayList<Integer> ();
		profile = new Profile("username", "password", "email", modelList, "firstName",
				"lastName");
		
		assertTrue(profile.getUsername().compareTo("username") == 0);
		assertTrue(profile.getPassword().compareTo("password") == 0);
		assertTrue(profile.getEmail().compareTo("email") == 0);
		assertTrue(profile.getModelList() == modelList);
		assertTrue(profile.getFirstName().compareTo("firstName") == 0);
		assertTrue(profile.getLastName().compareTo("lastName") == 0);
	}

	//Testing getters and setters
	@Test
	public void testUsername() {
		profile.setUsername("This is the username");
		assertTrue(profile.getUsername().compareTo("This is the username") == 0);
	}

	@Test
	public void testPassword() {
		profile.setPassword("This is the password");
		assertTrue(profile.getPassword().compareTo("This is the password") == 0);
	}

	@Test
	public void testEmail() {
		profile.setEmail("This is the email");
		assertTrue(profile.getEmail().compareTo("This is the email") == 0);
	}

	@Test
	public void testModelList() {
		List<Integer> list = new ArrayList<Integer> ();
		profile.setModelList(list);
		assertTrue(profile.getModelList() == list);
	}

	@Test
	public void testFirstName() {
		profile.setFirstName("This is the firstname");
		assertTrue(profile.getFirstName().compareTo("This is the firstname") == 0);
	}
	
	@Test
	public void testLastName() {
		profile.setLastName("This is the lastname");
		assertTrue(profile.getLastName().compareTo("This is the lastname") == 0);
	}

	//The following two tests are also testing the method isLoggedIn
	@Test
	public void testLogIn() {
		profile.logIn();
		assertTrue(profile.isLoggedIn());
	}

	@Test
	public void testLogOut() {
		profile.logOut();
		assertFalse(profile.isLoggedIn());
	}
}
