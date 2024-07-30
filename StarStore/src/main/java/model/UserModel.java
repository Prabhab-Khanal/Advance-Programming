package model;

import java.time.LocalDate;

public class UserModel {
	private String firstName;
	private String middleName;
    private String lastName; 
    private LocalDate dob;
    private String gender;
    private String email;
    private String phoneNumber;
    private String address;
    private String username;
    private String password;
    public UserModel() {
    	super();
    }

    public UserModel(String firstName, String lastName, String middleName, LocalDate dob, String gender, String email, String phoneNumber, String address, String username, String password) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob= dob;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.username = username;
        this.password = password;
    }
    public String getFirstName() {
		return firstName;
	}
    public String getMiddleName() {
		return middleName;
	}
    public String getLastName() {
		return lastName;
	}
    public LocalDate getDob() {
		return dob;
	}
    public String getAddress() {
		return address;
	}
    public String getEmail() {
		return email;
	}
    public String getGender() {
		return gender;
	}
    public String getPassword() {
		return password;
	}
    public String getPhoneNumber() {
		return phoneNumber;
	}
    public String getUsername() {
		return username;
	}
    public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
    public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
    public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    public void setDob(LocalDate dob) {
		this.dob = dob;
	}
    public void setAddress(String address) {
		this.address = address;
	}
    public void setEmail(String email) {
		this.email = email;
	}
    public void setGender(String gender) {
		this.gender = gender;
	}
    public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    public void setUsername(String username) {
		this.username = username;
	}
    public void setPassword(String password) {
		this.password = password;
	}
    
}
