package helper.db;

import java.util.*;
import java.sql.*;

import helper.info.*;

public class MySQLdb {
	private String url = "jdbc:mysql://localhost:3306/txirrindu";
    private String user = "root"; 
    private String passwd = "root";
	private String driver = "com.mysql.jdbc.Driver";
	
    private Connection conn;
	
	public MySQLdb() {
		try {
        	Class.forName(this.driver).newInstance();
        	this.conn = DriverManager.getConnection(this.url,this.user,this.passwd);
    	} catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}

	public void setUserInfo(String email ,String password, String username, String name, String surname1, String surname2, String postalCode, String country, String city, String phoneNumber, String license) {
		String query = "INSERT INTO txirrindu.users VALUES ('" + email + "', '" + password + "', '" + username + "', '" + name + "', '" + surname1 + "', '" + surname2 + "', '" + postalCode + "', '" + country + "', '" + city + "', '" + phoneNumber + "' , '" + license + "');";
		System.out.println("     DB query: " + query);
    	try {
	    	Statement st = this.conn.createStatement();
	    	st.executeUpdate(query);  	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}
	
	public void updatePassword(String email, String pasahitzZaharra, String pasahitzBerria){
		String query = "UPDATE txirrindu.users SET password='" +pasahitzBerria+ "' WHERE email='" + email +"'AND password ='" + pasahitzZaharra + "'";
		System.out.println("     DB query: " + query);
    	try {
	    	Statement st = this.conn.createStatement();
	    	st.executeUpdate(query);  	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}
	
	public void updatePerfil(String email, String username, String name, String surname1, String surname2, String postalCode, String country, String city, String phoneNumber){
		String query = "UPDATE txirrindu.users SET username='" + username + "', name= '" + name + "', surname1 ='" + surname1 +"',surname2 ='" + surname2 +"',postalCode ='" + postalCode +"',country ='" + country +"',city ='" + city +"', phoneNumber ='" + phoneNumber +"' WHERE email = '" + email + "' ;";
		System.out.println("     DB query: " + query);
    	try {
	    	Statement st = this.conn.createStatement();
	    	st.executeUpdate(query);  	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}
	
	public void updateLizentzia(String email, String lizentzia){
		String query = "UPDATE txirrindu.users SET license='" + lizentzia + "' WHERE email = '" + email + "' ;";
		System.out.println("     DB query: " + query);
    	try {
	    	Statement st = this.conn.createStatement();
	    	st.executeUpdate(query);  	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}
	
	
	public String getPasahitza(String username){
		String query = "SELECT password FROM txirrindu.users WHERE username = '" + username + "';";
		System.out.println("     DB query: " + query);
		String password = null;
    	try {
	    	Statement st = this.conn.createStatement();
	    	ResultSet res = st.executeQuery(query); 
	    	while(res.next()) {
	    		password = res.getString("password");
        	}
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return password;
	}
	
	public String getEmail(String username) {
		String query = "SELECT email FROM txirrindu.users WHERE username='" + username +  "';";
		System.out.println("     DB query: " + query);
		String email = null;
    	try {
	    	Statement st = this.conn.createStatement();
	    	ResultSet res = st.executeQuery(query); 
	    	while(res.next()) {
	    		email = res.getString("email");
        	}
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return email;
	}
	
	public String getUsername(String email, String password) {
		String query = "SELECT username FROM txirrindu.users WHERE email='" + email + "' AND password='" + password + "';";
		System.out.println("     DB query: " + query);
		String username = null;
    	try {
	    	Statement st = this.conn.createStatement();
	    	ResultSet res = st.executeQuery(query); 
	    	while(res.next()) {
	    		username = res.getString("username");
        	}
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return username;
	}
	
	public ArrayList<Object> getInfo(String email) {
		String query = "SELECT * FROM txirrindu.users WHERE email='" + email+ "';";
		System.out.println("     DB query: " + query);
		ArrayList<Object> userInfo = new ArrayList<Object>();
    	try {
	    	Statement st = this.conn.createStatement();
	    	ResultSet res = st.executeQuery(query); 
	    	while(res.next()) {
	    		userInfo.add(res.getObject("name"));
	    		userInfo.add(res.getObject("surname1"));
	    		userInfo.add(res.getObject("surname2"));
	    		userInfo.add(res.getObject("postalCode"));
	    		userInfo.add(res.getObject("country"));
	    		userInfo.add(res.getObject("city"));
	    		userInfo.add(res.getObject("phoneNumber"));
	    		userInfo.add(res.getObject("license"));
	    		userInfo.add(res.getObject("username"));
        	}
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return userInfo;
	}
	
	/*public void setMessageInfo(String message, String username) {
		String query = "INSERT INTO txirrindu.messages VALUES ('0', '" + message + "', '" + username + "');";
		System.out.println("     DB query: " + query);
    	try {
	    	Statement st = this.conn.createStatement();
	    	st.executeUpdate(query);  	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
	}
	
	public ArrayList<MessageInfo> getAllMessages() {
		String query = "SELECT * FROM txirrindu.messages;";
		System.out.println("     DB query: " + query);
		ArrayList<MessageInfo> messageInfoList = new ArrayList<MessageInfo>(); 
    	try {
	    	Statement st = this.conn.createStatement();
        	ResultSet res = st.executeQuery(query); 
        	while(res.next()) {
        		messageInfoList.add(new MessageInfo(res.getString("message"), res.getString("username")));
        	} 	
        } catch(Exception e) {
        	System.out.println("Exception: " + e.getMessage());
    	}
    	return messageInfoList;
	}*/
	
}