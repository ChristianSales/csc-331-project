package model;

public class CredentialModel {
	private String username;
	private String password;

	public CredentialModel() {
	}

	CredentialModel(String u, String p) {
		username = u;
		password = p;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * send data to database, check credential
	 * @return
	 */
	public boolean isValidUser(){
		return false;
	}

}