package model;

import java.util.List;

public class Profile {
	private String username;
	private String password;
	private String email;
	private List<Integer> modelList;
	private String firstName;
	private String lastName;
	private boolean loggedIn;  //check with team if this is okay
	
	public Profile() {
		
	}
	
	public Profile(String username, String password, String email, List<Integer> modelList, String firstName,
			String lastName) {
		
		this.username = username;
		this.password = password;
		this.email = email;
		this.modelList = modelList;
		this.firstName = firstName;
		this.lastName = lastName;
		loggedIn = false;
	}
	
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public List<Integer> getModelList() { return modelList; }
	public void setModelList(List<Integer> modelList) { this.modelList = modelList; }
	
	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	
	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	
	public void logIn() { loggedIn = true; }
	public void logOut() { loggedIn = false; }
	public boolean isLoggedIn() { return loggedIn; }
}
