package com.hdm.Notebee.server.db;


import com.hdm.Notebee.shared.bo.User;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


/**
 * Notebook Mapper Klasse bildet Notebook-Objekte auf eine relationale Datenbank
 * ab. Diese Klasse stellt Methoden zur Verfuegung, die das erstellen,
 * editieren, auslesen/suchen und loeschen der gewuenschten Datensaezte
 * erlauben. Die Mapperklasse stellt die Verbindungsschicht zwischen Datenbank
 * und Applikationslogik dar. Datenbank-Strukturen koennen in Objekte
 * umgewandelt werden, jedoch auch Objekte in Datenbankstrukturen
 */

public class UserMapper {
	
	// Klasse wird nur ein mal instantiiert (Singleton)
	private static UserMapper userMapper = null;
	
	// geschuetzter Konstruktor verhindert die Moeglichkeit mit new neue INstanzen der Klasse zu erzeugen
	protected UserMapper() {
	}
		
		/*
		 * Diese Methode ist statisch. Sie stellt die Singelton-Eigenschaft sicher, 
		 * es kann nur eine Instanz von UserMaper existieren
		 */
	public static UserMapper userMapper(){
		if(userMapper == null){
				userMapper = new UserMapper();
		}
		return userMapper;
	}
		
	
	
	
	public User findByGooglemail(String googlemail){
		
		//DB Verbindung holen
		Connection con = DBConnection.connection();
		
		try{
			//Leeres SQL Statement anlegen
			Statement stmt=con.createStatement();
			
			//Statement ausfuellen und als Query an DB senden
			ResultSet rs=stmt.executeQuery("SELECT googlemail, firstname, lastname FROM User" + "WHERE googlemail=" + googlemail);
			
			if(rs.next()){
				//Ergebnis Tupel in Objekt umwandeln
				User user = new User();
				user.setGooglemail(rs.getString("googlemail"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				return user;
			}
		}
			catch (SQLException e){
				e.printStackTrace();
				return null;
			}
			return null;

		}
	
		
	
	public Vector<User> findByLastname(String lastname){
		
		Connection con = DBConnection.connection();
		Vector<User> result = new Vector<User>();
		
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT userid, googlemail, firstname, lastname FROM user" + "WHERE lastname=" + lastname + "ORDER BY lastname");
		
		
			while(rs.next()){
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setGooglemail(rs.getString("googlemail"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
			
				result.addElement(user);
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
	
	
	
	
	
	public Vector<User> findAll(){
		
		Connection con = DBConnection.connection();
		Vector<User> result = new Vector<User>();
		
		
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT userid, googlemail, firstname, lastname FROM user" + "ORDER BY googlemail");
			
			while(rs.next()){
				User user = new User();
				
				user.setUserid(rs.getInt("userid"));
				user.setGooglemail(rs.getString("googlemail"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				
				result.addElement(user);
			}
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
		
		
		
		public User insert(User user){
			Connection con = DBConnection.connection();
			
			try{
				Statement stmt = con.createStatement();
				
				ResultSet rs = stmt.executeQuery("SELECT MAX(userid) AS maxid" + "FROM user");
				if (rs.next()){
					user.setUserid(rs.getInt("maxid")+1);
					
					stmt = con.createStatement();
					stmt.executeUpdate("INSERT INTO user (userid, mail, firstname, lastname)" + "VALUES(" + user.getUserid()+"," + user.getGooglemail() + "," + user.getFirstname() + "," + user.getLastname() + ")" );
					
					return user;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		
			return null;
		}
		
		
	
		
		public void delete (User user){
			Connection con = DBConnection.connection();
			
			try{
				Statement stmt = con.createStatement();
				stmt.executeUpdate("DELETE FROM user" + "WHERE user=" + user.getUserid());
			} 
			
			catch (SQLException e){
				e.printStackTrace();
			}
		}
		
	
		
		
		
		
		public User edit(User user){
			Connection con = DBConnection.connection();
			
			try{
				Statement stmt = con.createStatement();
				stmt.executeUpdate("UPDATE user" + "SET firstname=" +user.getFirstname() + "SET lastname=" + user.getLastname() + "WHERE userid=" + user.getUserid());
			}
			
			catch (SQLException e){
				e.printStackTrace();
				
			}
			return user;
		}
		
	
		

		

	
		
		
		
		
		
	
	
	
	
	
	

}
