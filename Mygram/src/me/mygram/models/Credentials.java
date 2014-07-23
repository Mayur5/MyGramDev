package me.mygram.models;

public class Credentials {
	private String firstName;
	private String lastName;
	private String userName;
	private String dateOfBith;
	private String languagePreference;
	private String emailAddress;
	private String password;
	
	public Credentials() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Credentials(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDateOfBith() {
		return dateOfBith;
	}
	public void setDateOfBith(String dateOfBith) {
		this.dateOfBith = dateOfBith;
	}
	public String getLanguagePreference() {
		return languagePreference;
	}
	public void setLanguagePreference(String languagePreference) {
		this.languagePreference = languagePreference;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
