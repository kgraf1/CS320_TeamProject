package controllers;

import model.Profile;

public class LoginController {

	private Profile profile = null;
	
	public LoginController(Profile profile) {
		this.profile = profile;
	}
	
	public boolean checkUserName(String name) {
		//return profile.validateUserName(name);
		return true;
	}
	
	public boolean validateCredentials(String name, String pw) {
		//return profile.validatePW(name, pw);
		return true;
	}
}
