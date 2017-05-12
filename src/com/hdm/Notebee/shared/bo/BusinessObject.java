package com.hdm.Notebee.shared.bo;

import java.io.Serializable;



/**
 * Die abstrakte Klasse <code>BusinessObject</code> implementiert das Interface
 * <code>Serializable</code> und ist somit serilisierbar. Sie stellt die
 * Elternklasse f�r alle BusinessObjects dar, die �ber die GUI verwendet werden.
 * 
 * Die Klasse ist abstrakt und mit static final <code> serialVersionUID</code>
 * ausgestattet, dies ist wichtiger Bestandteil f�r die Serialisierung.
 *
 */

public class BusinessObject implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int id = 0;

	/**
	 * Gibt die eindeutige Datenbank-ID des Objekts zur�ck.
	 * 
	 * @return id
	 */
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	/**
	 * Gibt ein Objekt als String zur�ck. Dabei wird ein Format definiert
	 * 
	 * @return String im vorgefertigten Format
	 */

	public String toString() {

		return this.getClass().getName() + " #" + this.id;
	}

	
	
	
	/**
	 * Vergleicht das aufrufende BO mit dem im Parameterbereich �bergebenen BO.
	 * 
	 * @param o
	 * @return boolischer Wert
	 */

	public boolean equals(Object o) {

		if (o != null && o instanceof BusinessObject) {
			BusinessObject bo = (BusinessObject) o;
			try {
				if (bo.getId() == this.id)
					return true;
			} catch (IllegalArgumentException e) {

				return false;
			}
		}

		return false;
	}
	

}
