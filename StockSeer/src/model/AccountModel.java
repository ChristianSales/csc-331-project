package model;

public class AccountModel {
	private String firstName, lastName, username;

	public AccountModel() {
	}

	public AccountModel(String username, String firstName, String lastName) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public boolean getStatus() {
		// FIXME rough estimation
		if (username != null)
			return true;
		return false;
	}

}
