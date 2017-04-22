package com.hdm.Notebee.shared.bo;

import java.util.Date;

public class Notebook extends BusinessObject {

	private static final long serialVersionUID = 1L;
	
	private int nbID;
	private String nbTitle;
	private String nbContent;
	private Date nbCreDate;
	private Date nbModDate;
	
	public int getNbID() {
		return nbID;
	}
	
	public void setNbID(int nbID) {
		this.nbID = nbID;
	}

	public String getNbTitle() {
		return nbTitle;
	}

	public void setNbTitle(String nbTitle) {
		this.nbTitle = nbTitle;
	}

	public String getNbContent() {
		return nbContent;
	}

	public void setNbContent(String nbContent) {
		this.nbContent = nbContent;
	}

	public Date getNbModDate() {
		return nbModDate;
	}

	public void setNbModDate(Date nbModDate) {
		this.nbModDate = nbModDate;
	}

	public Date getNbCreDate() {
		return nbCreDate;
	}

	public void setNbCreDate(Date nbCreDate) {
		this.nbCreDate = nbCreDate;
	}
	
	
}
