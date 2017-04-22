package com.hdm.Notebee.shared.bo;


public class User extends BusinessObject {
	
	private static final long serialVersionUID = 1L;

	
	private String googlemail;
	private String firstname;
	private String lastname;
	private int userid;
	
	public String getGooglemail() {
		return googlemail;
	}
	
	public void setGooglemail(String googlemail) {
		this.googlemail = googlemail;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	

}
