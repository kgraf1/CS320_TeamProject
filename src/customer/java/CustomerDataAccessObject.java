package customer.java;

public interface CustomerDataAccessObject {

	public int insertCustomer(Customer c);
	public Customer getCustomer(String username, String password);
}
