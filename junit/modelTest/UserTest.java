package modelTest;

import static org.junit.Assert.*;
import model.User;
import model.Profile;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private User user;
	
	@Before
	public void setUp() throws Exception {
		user = new User();
	}

	//testing the constructor
	@Test
	public void testUser() {
		Profile profile = new Profile();
		user = new User(profile);
		
		assertTrue(user.getProfile() == profile);
	}

	//testing the getters and setters
	@Test
	public void testProfile() {
		Profile profile = new Profile();
		user.setProfile(profile);
		
		assertTrue(user.getProfile() == profile);
	}
}
