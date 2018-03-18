package login.submit.registration;

public class Customer {
	private String username;
	private String name;
	private String password;
	private String email;
	
	public Customer(String username, String password, String name, String email) {
		this.username = username;
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	public Customer() {
		
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
