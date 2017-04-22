package com.hdm.Notebee.shared.bo;


public class Permission extends BusinessObject {
	
	private static final long serialVersionUID = 1L;
	
	private int permType;
	private int nbID;
	private int googlemail;
	
	public int getPermType() {
		return permType;
	}
	
	public void setPermType(int permType) {
		this.permType = permType;
	}
	
	public int getGooglemail() {
		return googlemail;
	}
	
	public void setGooglemail(int googlemail) {
		this.googlemail = googlemail;
	}

	public int getNbID() {
		return nbID;
	}

	public void setNbID(int nbID) {
		this.nbID = nbID;
	}
	

}
