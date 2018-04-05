package loginregistrationtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/*
import login.submit.registration.Customer;
import login.submit.registration.CustomerDataAccessImplementation;
import login.submit.registration.loginRegister;
*/


public class TestLogin {
	/*boolean setup = false;
	String testemail, testname, testpassword, testusername;
	//CustomerDataAccessImplementation data;
	//Customer test;
	@Before
	public void setUp() {
		 setup = true;
		 testemail = "testing123@gmail.com";
		 testname = "Bob";
		 testpassword = "dummy456";
		 testusername = "testdummy";
	}
	@Test
	public void testSetup() throws Exception {//tests that setup runs. can be deleted
		assertTrue(setup);
		
	}
	
	@Test
	public void testCustomer() throws Exception{//tests all of customers getter and setter methods
		Customer test = new Customer();//turn off if you want input in this test to carry over
		test.setEmail("testing123@gmail.com");
		assertEquals("testing123@gmail.com",test.getEmail());
		
		test.setName("Bob");
		assertEquals("Bob",test.getName());
		
		test.setPassword("dummy456");
		assertEquals("dummy456",test.getPassword());
		
		test.setUsername("testdummy");
		assertEquals("testdummy",test.getUsername());
	}
	@Test
	public void DataAccessInsertCustomer() throws Exception {//tests if something can be inserted. 
		CustomerDataAccessImplementation data = new CustomerDataAccessImplementation();
		Customer test = new Customer(testusername,testpassword,testname,testemail);
		Customer test2 = null;
		
		int status = data.insertCustomer(test);
		assertEquals(1,status);
		
		status = data.insertCustomer(test2);
		assertEquals(0, status);
	}
	
	@Test
	public void DataAccessGetCustomer() throws Exception {//tests if customers can be accessed properly
		
		/*check to see if it returns null if customer is not in database
		 * Should return null
		*/
	/*
		Customer test = new Customer();
		test.setEmail("doesnotexist@gmail.com");	
		test.setName("cannotsee");	
		test.setPassword("notreal");	
		test.setUsername("help");
		
		CustomerDataAccessImplementation data = new CustomerDataAccessImplementation();
		Customer returned = data.getCustomer(test.getUsername(), test.getPassword());	
		assertNull(returned.getUsername());
		assertNull(returned.getPassword());
		
		/*Now customer should exist
		 * 
		 */
	/*
		test = new Customer(testusername,testpassword,testname,testemail);
		returned = data.getCustomer(testusername, testpassword);
		assertEquals(testusername,returned.getUsername());
		assertEquals(testpassword,returned.getPassword());
	}*/
}
